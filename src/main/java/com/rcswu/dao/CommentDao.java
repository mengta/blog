package com.rcswu.dao;

import com.rcswu.domain.Comment;

import java.util.List;

public interface CommentDao extends CommonDao<Comment> {
    List<Comment> findCommentsByArticle(String articleId);
    List<Object[]> findUserComments(String userId);
    List<Object[]> findUserArticlesComments(String userId);
}
