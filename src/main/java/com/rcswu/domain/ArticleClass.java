package com.rcswu.domain;

import java.io.Serializable;

public class ArticleClass implements Serializable {
    private String caId;
    private Article article;
    private PersonalClassification personalClassification;

    public ArticleClass() {
    }

    public ArticleClass(Article article, PersonalClassification personalClassification) {
        this.article = article;
        this.personalClassification = personalClassification;
    }

    public String getCaId() {
        return caId;
    }

    public void setCaId(String caId) {
        this.caId = caId;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public PersonalClassification getPersonalClassification() {
        return personalClassification;
    }

    public void setPersonalClassification(PersonalClassification personalClassification) {
        this.personalClassification = personalClassification;
    }
}
