package com.rcswu.service.impl;

import com.rcswu.dao.CommentDao;
import com.rcswu.domain.Comment;
import com.rcswu.service.CommentService;
import com.rcswu.utils.JsonConvertUtil;

import java.io.IOException;
import java.util.List;

public class CommentServiceImpl extends CommonServiceImpl<Comment> implements CommentService {
    private CommentDao commentDao;

    public CommentDao getCommentDao() {
        return commentDao;
    }

    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public List<Comment> findCommentsByArticle(String articleId) {
        List<Comment> comments=commentDao.findCommentsByArticle(articleId);
        return comments;
    }

    @Override
    public String findUserComments(String userId) throws IOException {
        List<Object[]> comments=commentDao.findUserArticlesComments(userId);
        String json= JsonConvertUtil.returnJson(comments);
        return json;
    }

    @Override
    public String findUserArticlesComments(String userId) throws IOException {
        List<Object[]> comments=commentDao.findUserArticlesComments(userId);
        String json=JsonConvertUtil.returnJson(comments);
        return json;
    }
}
