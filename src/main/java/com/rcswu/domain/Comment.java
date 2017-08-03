package com.rcswu.domain;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
    private String commentId;
    private User userByReplyUser;
    private User userByCommentUser;
    private Article commentArticle;
    private Integer floor;
    private String commentContent;
    private Date commentDate;

    public Comment() {
    }

    public Comment(User userByReplyUser, User userByCommentUser, Article commentArticle, Integer floor, String commentContent, Date commentDate) {
        this.userByReplyUser = userByReplyUser;
        this.userByCommentUser = userByCommentUser;
        this.commentArticle = commentArticle;
        this.floor = floor;
        this.commentContent = commentContent;
        this.commentDate = commentDate;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public User getUserByReplyUser() {
        return userByReplyUser;
    }

    public void setUserByReplyUser(User userByReplyUser) {
        this.userByReplyUser = userByReplyUser;
    }

    public User getUserByCommentUser() {
        return userByCommentUser;
    }

    public void setUserByCommentUser(User userByCommentUser) {
        this.userByCommentUser = userByCommentUser;
    }

    public Article getCommentArticle() {
        return commentArticle;
    }

    public void setCommentArticle(Article commentArticle) {
        this.commentArticle = commentArticle;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }
}
