package com.rcswu.domain;

import java.io.Serializable;
import java.util.Date;

public class Collection implements Serializable {
    private String collectionId;
    private User user;
    private Article article;
    private Date collectDate;

    public Collection() {
    }

    public Collection(User user, Article article, Date collectDate) {
        this.user = user;
        this.article = article;
        this.collectDate = collectDate;
    }

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Date getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(Date collectDate) {
        this.collectDate = collectDate;
    }
}
