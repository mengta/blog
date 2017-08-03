package com.rcswu.domain;

import java.io.Serializable;
import java.util.Date;

public class Dynamic implements Serializable {
    private String dynamicId;
    private Article article;
    private User user;
    private Date dynamicDate;
    private Integer dynamicState;

    public Dynamic() {
    }

    public Dynamic(Article article, User user, Date dynamicDate, Integer dynamicState) {
        this.article = article;
        this.user = user;
        this.dynamicDate = dynamicDate;
        this.dynamicState = dynamicState;
    }

    public String getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(String dynamicId) {
        this.dynamicId = dynamicId;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDynamicDate() {
        return dynamicDate;
    }

    public void setDynamicDate(Date dynamicDate) {
        this.dynamicDate = dynamicDate;
    }

    public Integer getDynamicState() {
        return dynamicState;
    }

    public void setDynamicState(Integer dynamicState) {
        this.dynamicState = dynamicState;
    }
}
