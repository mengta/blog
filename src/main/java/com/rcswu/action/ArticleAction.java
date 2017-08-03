package com.rcswu.action;

import com.opensymphony.xwork2.ActionContext;
import com.rcswu.domain.*;
import com.rcswu.service.ArticleService;
import com.rcswu.service.DynamicService;
import com.rcswu.service.UserService;
import com.rcswu.utils.JsonConvertUtil;
import com.rcswu.utils.LuceneUtil;
import com.rcswu.utils.PageUtil;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

@SuppressWarnings("serial")
public class ArticleAction extends MyBaseAction {
    private ArticleService articleService;
    private UserService userService;
    private Article article;
    private String pageNumber;				//页码
    private String userId;					//访问的博客的主人id
    private String myArticleClassId;		//我的文章分类
    private String dateClass;				//我的存档
    private Integer articleClass;
    private String queryCondition;					//查询条件
    //struts2无法动态的设置标签name属性，意思就是无法设置下标，所以不用struts2标签，然后就无法使用ognl表达式
    //不用ognl表达式就无法传递set集合，所以就用list集合接收数据
    private List<PersonalClassification> classList;
    private DynamicService dynamicService;

    public ArticleService getArticleService() {
        return articleService;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMyArticleClassId() {
        return myArticleClassId;
    }

    public void setMyArticleClassId(String myArticleClassId) {
        this.myArticleClassId = myArticleClassId;
    }

    public String getDateClass() {
        return dateClass;
    }

    public void setDateClass(String dateClass) {
        this.dateClass = dateClass;
    }

    public Integer getArticleClass() {
        return articleClass;
    }

    public void setArticleClass(Integer articleClass) {
        this.articleClass = articleClass;
    }

    public String getQueryCondition() {
        return queryCondition;
    }

    public void setQueryCondition(String queryCondition) {
        this.queryCondition = queryCondition;
    }

    public List<PersonalClassification> getClassList() {
        return classList;
    }

    public void setClassList(List<PersonalClassification> classList) {
        this.classList = classList;
    }

    public DynamicService getDynamicService() {
        return dynamicService;
    }

    public void setDynamicService(DynamicService dynamicService) {
        this.dynamicService = dynamicService;
    }

    public String saveArticle() throws IOException {
        if(baseUser==null){
            setState("3");
            setMessage("loginView.action");
            return SUCCESS;
        }
        Set<ArticleClass> clSet=new HashSet<>();
        if(classList!=null&&classList.size()>0){
            for(PersonalClassification cl:classList){
                if(cl!=null){
                    ArticleClass articleClass=new ArticleClass();
                    articleClass.setPersonalClassification(cl);
                    clSet.add(articleClass);
                }
            }
        }else{
            Set<PersonalClassification> personCls=baseUser.getPersonalClassifications();
            Iterator<PersonalClassification> iterator=personCls.iterator();
            while(iterator.hasNext()){
                PersonalClassification userCl=iterator.next();
                if(userCl==null){
                    continue;
                }
                if(userCl.getDefaultSetting()!=null&&userCl.getDefaultSetting()==0){
                    ArticleClass articleClass=new ArticleClass();
                    articleClass.setPersonalClassification(userCl);
                    clSet.add(articleClass);
                }
            }
        }
        article.setArticleDate(Calendar.getInstance().getTime());
        article.setUserByAuthorId(baseUser);
        article.setReadnum(0);
        article.setArticleClasses(clSet);
        if(article.getArticleId()==null||article.getArticleId().isEmpty()){
            Serializable id=articleService.saveEntity(article);
            article.setArticleId(id.toString());
            LuceneUtil.add(article);
        }else{
            articleService.updateEntity(article);
            LuceneUtil.update(article);
        }
        setState("0");
        Dynamic dynamic=new Dynamic(article,baseUser,Calendar.getInstance().getTime(),0);
        dynamicService.saveEntity(dynamic);
        return SUCCESS;
    }
    public String writeArticle(){
        if(baseUser==null){
            return "index";
        }
        if(article!=null&&!article.getArticleId().isEmpty()){
            Article editArticle=articleService.getEntityById(article.getArticleId());
            ServletActionContext.getRequest().setAttribute("article",editArticle);
            return SUCCESS;
        }
        Article draftArticle=articleService.getArticleByState(0);
        if(draftArticle!=null){
            ServletActionContext.getRequest().setAttribute("article",draftArticle);
        }
        return SUCCESS;
    }
    public String deleteArticle() throws IOException {
        if(baseUser==null){
            setState("3");
            setMessage("loginView.action");
            return SUCCESS;
        }
        if(article!=null&&!article.getArticleId().isEmpty()){
            LuceneUtil.delete(article.getArticleId());
            articleService.deleteEntityById(article.getArticleId());
            setState("0");
            setMessage("删除成功！");
        }else{
            setState("2");
            setMessage("删除失败！");
        }
        return "deleteArticle";
    }
    public String index(){
        List<User> users=userService.getRecommendUsers();
        PageUtil articlePage=articleService.findArticlesPage("1");
        ActionContext.getContext().put("users",users);
        ActionContext.getContext().put("page",articlePage);
        return SUCCESS;
    }
    public String getArticleList(){
        PageUtil articlePage=articleService.findArticlesPage(pageNumber);
        ActionContext.getContext().put("page",articlePage);
        return SUCCESS;
    }
    public String searchAllArticle(){
        List<Article> articles=new ArrayList<>();
        try {
            articles=LuceneUtil.search(queryCondition);
        } catch (ParseException e) {
            e.printStackTrace();
            return ERROR;
        } catch (IOException e) {
            e.printStackTrace();
            return ERROR;
        } catch (java.text.ParseException e) {
            e.printStackTrace();
            return ERROR;
        } catch (InvalidTokenOffsetsException e) {
            e.printStackTrace();
            return ERROR;
        }
        ActionContext.getContext().put("articleList",articles);
        return SUCCESS;
    }
    public String articleClass(){
        if(articleClass!=null&&!"".equals(articleClass)){
            ActionContext.getContext().getSession().put("articleClass",articleClass);
        }else{
            articleClass= (Integer) ActionContext.getContext().getSession().get("articleClass");
        }
        PageUtil articlesPage=articleService.findArticlesPageByClass(articleClass,pageNumber);
        ActionContext.getContext().put("page",articlesPage);
        return SUCCESS;
    }
    public String articleDetail(){
        Article articleDetail=articleService.getEntityById(article.getArticleId());
        if(articleDetail==null){
            return ERROR;
        }
        ActionContext.getContext().put("articleComments",articleService.handleCommentsForArticle(article.getArticleId()));
        User u=articleDetail.getUserByAuthorId();
        ActionContext.getContext().put("blogHost",u);
        ActionContext.getContext().getSession().put("visitedUser",u);
        ActionContext.getContext().put("articleDetail",articleDetail);
        ActionContext.getContext().put("articlesData",articleService.getMyBlogArticleData(u.getUserId()));
        if(baseUser!=null&&!baseUser.getUserId().equals(u.getUserId())){
            articleDetail.setReadnum(articleDetail.getReadnum()+1);
            articleService.updateEntity(articleDetail);
            u.setVisitedNum(u.getVisitedNum()+1);
            userService.updateEntity(u);
        }
        return SUCCESS;
    }
    public String myBlogView(){
        User u=userService.getEntityById(userId);
        ActionContext.getContext().put("blogHost",u);
        ActionContext.getContext().getSession().put("visitedUser",u);
        ActionContext.getContext().put("page",articleService.findUserArticlesPage(userId,pageNumber));
        ActionContext.getContext().put("articlesData",articleService.getMyBlogArticleData(userId));
        if(baseUser!=null&&!baseUser.getUserId().equals(u.getUserId())){
            u.setVisitedNum(u.getVisitedNum()+1);
            userService.updateEntity(u);
        }
        return SUCCESS;
    }
    public String getMyArticlesList(){
        ActionContext.getContext().put("page",articleService.findUserArticlesPage(visitedUser.getUserId(),pageNumber));
        return SUCCESS;
    }
    public String searchArticle(){
        String searchTitle="";
        if(article!=null&&!article.getArticleTitle().isEmpty()){
            searchTitle=article.getArticleTitle();
        }
        if(searchTitle==null||"".equals(searchTitle)){
            searchTitle= (String) ActionContext.getContext().getSession().get("searchTitle");
        }else{
            ActionContext.getContext().getSession().put("searchTitle",searchTitle);
        }
        PageUtil page=articleService.findUserArticlesPageByTitle(visitedUser.getUserId(),searchTitle,pageNumber);
        ActionContext.getContext().put("page",page);
        return SUCCESS;
    }
    public String myClassArticle(){
        if(myArticleClassId==null||myArticleClassId.isEmpty()){
            myArticleClassId= (String) ActionContext.getContext().getSession().get("myArticleClassId");
        }else{
            ActionContext.getContext().getSession().put("myArticleClassId",myArticleClassId);
        }
        PageUtil page=articleService.findUserArticlesPageByClass(visitedUser.getUserId(),myArticleClassId,pageNumber);
        ActionContext.getContext().put("page",page);
        return SUCCESS;
    }
    public String myArticleGroupByDate(){
        if(dateClass==null||dateClass.isEmpty()){
            dateClass= (String) ActionContext.getContext().getSession().get("dateClass");
        }else{
            ActionContext.getContext().getSession().put("dateClass",dateClass);
        }
        PageUtil page=articleService.findUserArticlesGroupByDate(visitedUser.getUserId(),dateClass,pageNumber);
        ActionContext.getContext().put("page",page);
        return SUCCESS;
    }
    public String myArticleDetail(){
        Article articleDetail=articleService.getEntityById(article.getArticleId());
        ActionContext.getContext().put("articleDetail",articleService.getEntityById(article.getArticleId()));
        ActionContext.getContext().put("articleComments",articleService.handleCommentsForArticle(article.getArticleId()));
        if(baseUser!=null&&!baseUser.getUserId().equals(articleDetail.getUserByAuthorId().getUserId())){
            articleDetail.setReadnum(articleDetail.getReadnum()+1);
            articleService.updateEntity(articleDetail);
        }
        return SUCCESS;
    }
    public String getArticleComments(){
        ActionContext.getContext().put("articleComments",articleService.handleCommentsForArticle(article.getArticleId()));;
        return SUCCESS;
    }
    public String getMyArticlesListByAjax(){
        try {
            setMessage(JsonConvertUtil.returnJson(articleService.findUserArticlesPage(baseUser.getUserId(),pageNumber)));
            setState("0");
        } catch (IOException e) {
            e.printStackTrace();
            setState("2");
            setMessage("出错了！");
        }
        return SUCCESS;
    }
    public String blogManage(){
        if(baseUser!=null){
            return SUCCESS;
        }
        return ERROR;
    }
}
