package com.rcswu.service;

import com.rcswu.domain.Comment;

import java.io.IOException;
import java.util.List;

public interface CommentService extends CommonService<Comment> {
    List<Comment> findCommentsByArticle(String articleId);
    String findUserComments(String userId) throws IOException;
    String findUserArticlesComments(String userId) throws IOException;
}
