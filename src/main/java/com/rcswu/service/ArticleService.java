package com.rcswu.service;

import com.rcswu.domain.Article;
import com.rcswu.domain.Comment;
import com.rcswu.utils.PageUtil;

import java.util.List;
import java.util.Map;

public interface ArticleService extends CommonService<Article> {
    Article getArticleByState(Integer sate);
    PageUtil findArticlesPage(String pageNum);
    Map<String, Object> getMyBlogArticleData(String userId);
    List<Map<String,String>> getArticleDateGroup(String userId);
    List<Object[]> findArticleByCommentDesc(String userId);
    List<Object[]> findArticleByReadNumDesc(String userId);
    PageUtil findUserArticlesPage(String userId,String pageNum);
    PageUtil findArticlesPageByClass(Integer articleClass,String pageNum);
    PageUtil findUserArticlesPageByTitle(String userId,String articleTitle,String pageNum);
    PageUtil findUserArticlesPageByClass(String userId,String articleClass,String pageNum);
    PageUtil findUserArticlesGroupByDate(String userId,String dateClass,String pageNum);
    Map<Comment,List<Comment>> handleCommentsForArticle(String articleId);
}
