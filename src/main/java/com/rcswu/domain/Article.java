package com.rcswu.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Article implements Serializable {
    private String articleId;
    private User userByCollectorId;
    private User userByAuthorId;
    private String articleTitle;
    private String articleSummary;
    private String articleContent;
    private Integer commentNum;
    private Date articleDate;
    private Integer readnum;
    private String tag;
    private Integer type;
    private Integer classification;
    private Integer state;
    private Set comments = new HashSet(0);
    private Set articleClasses = new HashSet(0);
    private Set collection = new HashSet(0);
    private Set dynamicUser = new HashSet(0);

    public Article() {
    }

    public Article(String articleId, User userByAuthorId, String articleTitle, String articleSummary, Date articleDate, Integer readnum, Set comments, Set collection) {
        this.articleId = articleId;
        this.userByAuthorId = userByAuthorId;
        this.articleTitle = articleTitle;
        this.articleSummary = articleSummary;
        this.articleDate = articleDate;
        this.readnum = readnum;
        this.comments = comments;
        this.collection = collection;
    }

    public Article(User userByCollectorId, User userByAuthorId,
                   String articleTitle, String articleSummary,
                   String articleContent, Integer commentNum,
                   Date articleDate, Integer readnum, String tag,
                   Integer type, Integer classification, Integer state,
                   Set comments, Set articleClasses, Set dynamicUser) {
        this.userByCollectorId = userByCollectorId;
        this.userByAuthorId = userByAuthorId;
        this.articleTitle = articleTitle;
        this.articleSummary = articleSummary;
        this.articleContent = articleContent;
        this.commentNum = commentNum;
        this.articleDate = articleDate;
        this.readnum = readnum;
        this.tag = tag;
        this.type = type;
        this.classification = classification;
        this.state = state;
        this.comments = comments;
        this.articleClasses = articleClasses;
        this.dynamicUser = dynamicUser;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public User getUserByCollectorId() {
        return userByCollectorId;
    }

    public void setUserByCollectorId(User userByCollectorId) {
        this.userByCollectorId = userByCollectorId;
    }

    public User getUserByAuthorId() {
        return userByAuthorId;
    }

    public void setUserByAuthorId(User userByAuthorId) {
        this.userByAuthorId = userByAuthorId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    public Integer getReadnum() {
        return readnum;
    }

    public void setReadnum(Integer readnum) {
        this.readnum = readnum;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getClassification() {
        return classification;
    }

    public void setClassification(Integer classification) {
        this.classification = classification;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Set getComments() {
        return comments;
    }

    public void setComments(Set comments) {
        this.comments = comments;
    }

    public Set getArticleClasses() {
        return articleClasses;
    }

    public void setArticleClasses(Set articleClasses) {
        this.articleClasses = articleClasses;
    }

    public Set getCollection() {
        return collection;
    }

    public void setCollection(Set collection) {
        this.collection = collection;
    }

    public Set getDynamicUser() {
        return dynamicUser;
    }

    public void setDynamicUser(Set dynamicUser) {
        this.dynamicUser = dynamicUser;
    }
}
