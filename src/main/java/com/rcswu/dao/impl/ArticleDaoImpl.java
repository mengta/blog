package com.rcswu.dao.impl;

import com.rcswu.dao.ArticleDao;
import com.rcswu.domain.Article;
import com.rcswu.utils.PageHibernateCallBackUtil;
import org.springframework.orm.hibernate3.HibernateCallback;

import java.util.List;

@SuppressWarnings("all")
public class ArticleDaoImpl extends CommonDaoImpl<Article> implements ArticleDao {
    @Override
    public Article getArticleByState(Integer state) {
        List<Article> articles= (List<Article>) getHibernateTemplate().find("from Article article where article.state=?",state);
        if(articles==null||articles.size()==0){
            return null;
        }
        return articles.get(0);
    }

    @Override
    public Integer getArticleCount(String condition) {
        return ((Long)getHibernateTemplate().find(condition).listIterator().next()).intValue();
    }

    @Override
    public List<Article> findSomeArticles(int startIndex, int articleNum) {
        List<Article> articles= (List<Article>) getHibernateTemplate().execute((HibernateCallback<Article>)new PageHibernateCallBackUtil(
                "from Article article order by article.articleDate desc",startIndex,articleNum,null
        ));
        if(articles==null||articles.size()==0){
            return null;
        }
        return articles;
    }

    @Override
    public List<Object[]> findArticleFieldList(String condition, int startIndex, int dataNumber) {
        List<Object[]> dataList= (List<Object[]>) getHibernateTemplate().execute((HibernateCallback<Object>)new PageHibernateCallBackUtil(
                condition,startIndex,dataNumber,null
        ));
        return dataList;
    }

    @Override
    public Integer getUserArticlesCount(String userId) {
        return ((Long)getHibernateTemplate().find("select count(*) from Article a left join a.userByAuthorId u where u.userId="+userId).listIterator().next()).intValue();
    }
}
