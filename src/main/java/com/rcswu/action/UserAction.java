package com.rcswu.action;

import com.opensymphony.xwork2.ActionContext;
import com.rcswu.domain.Education;
import com.rcswu.domain.LoginLog;
import com.rcswu.domain.User;
import com.rcswu.domain.Work;
import com.rcswu.exceptions.PasswordIsError;
import com.rcswu.exceptions.UserIsNotFound;
import com.rcswu.service.*;
import com.rcswu.utils.GetIpUtil;
import com.rcswu.utils.JsonConvertUtil;
import com.rcswu.utils.MD5Util;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("serial")
public class UserAction extends MyBaseAction {
    private UserService userService;
    private LoginLogService loginLogService;
    private ArticleService articleService;
    private User user;
    private String validateCode;
    private String remember;
    private Education education;
    private EducationService educationService;
    private Work work;
    private WorkService workService;
    private String attentionId;
    private AttentionService attentionService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public LoginLogService getLoginLogService() {
        return loginLogService;
    }

    public void setLoginLogService(LoginLogService loginLogService) {
        this.loginLogService = loginLogService;
    }

    public ArticleService getArticleService() {
        return articleService;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    public String getRemember() {
        return remember;
    }

    public void setRemember(String remember) {
        this.remember = remember;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public EducationService getEducationService() {
        return educationService;
    }

    public void setEducationService(EducationService educationService) {
        this.educationService = educationService;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public WorkService getWorkService() {
        return workService;
    }

    public void setWorkService(WorkService workService) {
        this.workService = workService;
    }

    public String getAttentionId() {
        return attentionId;
    }

    public void setAttentionId(String attentionId) {
        this.attentionId = attentionId;
    }

    public AttentionService getAttentionService() {
        return attentionService;
    }

    public void setAttentionService(AttentionService attentionService) {
        this.attentionService = attentionService;
    }
    public String quit(){
        ServletActionContext.getContext().getSession().remove("user");
        return SUCCESS;
    }
    public String userLogin(){
        if(haveError("用户登录失败！")){
            return LOGIN;
        }
        User u;
        try {
            u=userService.userLogin(user);
            String path=ServletActionContext.getRequest().getServletContext().getContextPath();
            Cookie userName=new Cookie("userName","");
            userName.setMaxAge(60*60*24*7);
            userName.setPath(path);
            Cookie password=new Cookie("password","");
            password.setMaxAge(60*60*24*7);
            password.setPath(path);
            if("on".equals(remember)){
                userName.setValue(user.getUserName());
                password.setValue(user.getPassword());
            }
            ServletActionContext.getResponse().addCookie(userName);
            ServletActionContext.getResponse().addCookie(password);
            setState("0");
            loginLog(u);
            ActionContext.getContext().getSession().put("user",u);
        } catch (UserIsNotFound userIsNotFound) {
            setState("2");
            setMessage(userIsNotFound.getMessage());
        } catch (PasswordIsError passwordIsError) {
            setState("2");
            setMessage(passwordIsError.getMessage());
        }
        return LOGIN;
    }
    public void loginLog(User user){
        LoginLog loginLog=new LoginLog();
        loginLog.setUser(user);
        loginLog.setLoginUsername(user.getUserName());
        loginLog.setLoginDate(Calendar.getInstance().getTime());
        loginLog.setLoginIp(GetIpUtil.getIpAddr(ServletActionContext.getRequest()));
        loginLogService.saveEntity(loginLog);
    }
    public String personalInfo(){
        if(user==null||user.getUserId().isEmpty()){
            return "error";
        }
        try {
            user=userService.getUserById(user.getUserId());
            ServletActionContext.getContext().getSession().put("visitedUser",user);
            setMessage(JsonConvertUtil.returnJson(user));
            if(baseUser!=null){
                setAttentionId(attentionService.findAttentionId(user.getUserId(),baseUser.getUserId()));
            }else{
                setAttentionId("1");
            }
            setState("0");
        } catch (Exception e) {
            return "error";
        }
        return "personal";
    }
    public String saveEducation(){
        if(education!=null){
            education.setUser(baseUser);
            if(education.getEducationId()==null||education.getEducationId().isEmpty()){
                educationService.saveEntity(education);
            }else{
                educationService.updateEntity(education);
            }
            setState("0");
            setMessage("保存学历背景成功！");
        }else{
            setState("2");
            setMessage("保存学历背景失败！");
        }
        return "personal";
    }
    public String deleteEducation(){
        if(education!=null&&education.getEducationId()!=null){
            educationService.deleteEntityById(education.getEducationId());
            setState("0");
            setMessage("删除成功！");
        }else{
            setState("0");
            setMessage("删除成功！");
        }
        return "personal";
    }
    public String saveWork(){
        if(work!=null){
            work.setUser(baseUser);
            if("".equals(work.getWorkId())||work.getWorkId()==null){
                workService.saveEntity(work);
            }else{
                workService.updateEntity(work);
            }
            setState("0");
            setMessage("保存工作经历成功！");
        }else{
            setState("2");
            setMessage("保存工作经历失败！");
        }
        return "personal";
    }
    public String deleteWork(){
        if(work!=null&&work.getWorkId()!=null){
            workService.deleteEntityById(work.getWorkId());
            setState("0");
            setMessage("删除成功！");
        }else{
            setState("0");
            setMessage("删除成功！");
        }
        return "personal";
    }
    public String updateAccount(){
        if(baseUser==null){
            setState("3");
            setMessage("loginView.action");
            return "account";
        }
        if(user==null){
            setState("2");
            setMessage("不能为空");
            return "account";
        }
        baseUser.setUserName(user.getUserName());
        baseUser.setPassword(MD5Util.md5Encod(user.getPassword()));
        userService.updateEntity(baseUser);
        setState("0");
        setMessage("修改成功！");
        return "account";
    }
    public void validateUserLogin(){
        if("".equals(user.getUserName())){
            errorMessage.put("user.userName","用户名不能为空");
        }
        if("".equals(user.getPassword())){
            errorMessage.put("user.password","密码不能为空");
        }
        validateSendMail();
        if(validateCode.isEmpty()||validateCode==null){

        }
    }
    public void validateSendMail(){
        if(user.getEmail().isEmpty()){
            errorMessage.put("user.email","邮箱不能为空");
        }
        String check="^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\\\.)+[a-zA-Z]{2,}$";
        Pattern regex=Pattern.compile(check);
        Matcher matcher=regex.matcher(user.getEmail());
        if(!matcher.matches()){
            errorMessage.put("user.email","邮箱格式不正确");
        }
    }

}
