package com.rcswu.dao;

import com.rcswu.domain.Article;

import java.util.List;

public interface ArticleDao extends CommonDao<Article> {
    Article getArticleByState(Integer state);
    Integer getArticleCount(String condition);
    List<Article> findSomeArticles(int startIndex,int articleNum);
    List<Object[]> findArticleFieldList(String condition,int startIndex,int dataNumber);
    Integer getUserArticlesCount(String userId);
}
