package com.rcswu.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class PersonalClassification implements Serializable {
    private String classificationId;
    private User user;
    private String classificationName;
    private Set articleClasses = new HashSet(0);
    private Integer defaultSetting;

    public PersonalClassification() {
    }

    public PersonalClassification(User user, String classificationName, Set articleClasses) {
        this.user = user;
        this.classificationName = classificationName;
        this.articleClasses = articleClasses;
    }

    public String getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(String classificationId) {
        this.classificationId = classificationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    public Set getArticleClasses() {
        return articleClasses;
    }

    public void setArticleClasses(Set articleClasses) {
        this.articleClasses = articleClasses;
    }

    public Integer getDefaultSetting() {
        return defaultSetting;
    }

    public void setDefaultSetting(Integer defaultSetting) {
        this.defaultSetting = defaultSetting;
    }
}
