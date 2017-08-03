package com.rcswu.dao.impl;

import com.rcswu.dao.CommentDao;
import com.rcswu.domain.Comment;

import java.util.List;

@SuppressWarnings("all")
public class CommentDaoImpl extends CommonDaoImpl<Comment> implements CommentDao {
    @Override
    public List<Comment> findCommentsByArticle(String articleId) {
        return (List<Comment>) getHibernateTemplate().find("from Comment c left c.commentArticle a where a.article=?" +
                " order by commentDate desc",articleId);
    }

    @Override
    public List<Object[]> findUserComments(String userId) {
        List<Object[]> comments= (List<Object[]>) getHibernateTemplate().find("select c.commentId,c.commentContent,a.articleId," +
                "a.articleTitle,u.userId,u.userNickname from Comment c left join c.commentArticle a left join " +
                "c.commentArticle a left join c.userByCommentUser u where u.userId=?",userId);
        if(comments==null||comments.size()==0){
            return null;
        }
        return comments;
    }

    @Override
    public List<Object[]> findUserArticlesComments(String userId) {
        List<Object[]> comments= (List<Object[]>) getHibernateTemplate().find("select c.commentId,c.commentContent,a.articleTitle,u.userId," +
                "u.useNickname from Comment c left join c.commentArticle a left join a.userByAuthorId u where u.userId=?",userId);
        if(comments==null||comments.size()==0){
            return null;
        }
        return comments;
    }
}
