package com.rcswu.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(value={"optionLogs","articlesForCollectorId","articlesForAuthorId","attentionsForFollower","commentsForCommentUser",
        "loginLogs","attentionsForUser","personalClassifications","commentsForReplyUser","collection","dynamicUser","userBySendUser","userByReceiveUser"})
public class User implements Serializable,HttpSessionBindingListener {
    private String userId;
    private String userName;
    private String password;
    private String userNickname;
    private String userTruename;
    private String userImg;
    private Date birthday;
    private Integer gender;
    private String address;
    private String industry;
    private String career;
    private String email;
    private String telphone;
    private String qq;
    private String wechat;
    private String knowField;
    private String professionalSkill;
    private String myProvince;
    private String myCity;
    private String introduction;
    private Integer visitedNum;
    private Set educations = new HashSet(0);
    private Set optionLogs = new HashSet(0);
    private Set articlesForCollectorId = new HashSet(0);
    private Set articlesForAuthorId = new HashSet(0);
    private Set attentionsForFollower = new HashSet(0);
    private Set commentsForCommentUser = new HashSet(0);
    private Set works = new HashSet(0);
    private Set loginLogs = new HashSet(0);
    private Set attentionsForUser = new HashSet(0);
    private Set personalClassifications = new HashSet(0);
    private Set commentsForReplyUser = new HashSet(0);
    private Set collection = new HashSet(0);
    private Set dynamicUser = new HashSet(0);
    private Set userBySendUser = new HashSet(0);
    private Set userByReceiveUser = new HashSet(0);

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String userId, String userName, String password, String userNickname, String userTruename, String userImg, Date birthday, Integer gender, String address, String industry, String career, String email, String telphone, String qq, String wechat, String knowField, String professionalSkill, String myProvince, String myCity, String introduction, Integer visitedNum, Set educations, Set optionLogs, Set articlesForCollectorId, Set articlesForAuthorId, Set attentionsForFollower, Set commentsForCommentUser, Set works, Set loginLogs, Set attentionsForUser, Set personalClassifications, Set commentsForReplyUser, Set collection, Set dynamicUser, Set userBySendUser, Set userByReceiveUser) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.userNickname = userNickname;
        this.userTruename = userTruename;
        this.userImg = userImg;
        this.birthday = birthday;
        this.gender = gender;
        this.address = address;
        this.industry = industry;
        this.career = career;
        this.email = email;
        this.telphone = telphone;
        this.qq = qq;
        this.wechat = wechat;
        this.knowField = knowField;
        this.professionalSkill = professionalSkill;
        this.myProvince = myProvince;
        this.myCity = myCity;
        this.introduction = introduction;
        this.visitedNum = visitedNum;
        this.educations = educations;
        this.optionLogs = optionLogs;
        this.articlesForCollectorId = articlesForCollectorId;
        this.articlesForAuthorId = articlesForAuthorId;
        this.attentionsForFollower = attentionsForFollower;
        this.commentsForCommentUser = commentsForCommentUser;
        this.works = works;
        this.loginLogs = loginLogs;
        this.attentionsForUser = attentionsForUser;
        this.personalClassifications = personalClassifications;
        this.commentsForReplyUser = commentsForReplyUser;
        this.collection = collection;
        this.dynamicUser = dynamicUser;
        this.userBySendUser = userBySendUser;
        this.userByReceiveUser = userByReceiveUser;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserTruename() {
        return userTruename;
    }

    public void setUserTruename(String userTruename) {
        this.userTruename = userTruename;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getKnowField() {
        return knowField;
    }

    public void setKnowField(String knowField) {
        this.knowField = knowField;
    }

    public String getProfessionalSkill() {
        return professionalSkill;
    }

    public void setProfessionalSkill(String professionalSkill) {
        this.professionalSkill = professionalSkill;
    }

    public String getMyProvince() {
        return myProvince;
    }

    public void setMyProvince(String myProvince) {
        this.myProvince = myProvince;
    }

    public String getMyCity() {
        return myCity;
    }

    public void setMyCity(String myCity) {
        this.myCity = myCity;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getVisitedNum() {
        return visitedNum;
    }

    public void setVisitedNum(Integer visitedNum) {
        this.visitedNum = visitedNum;
    }

    public Set getEducations() {
        return educations;
    }

    public void setEducations(Set educations) {
        this.educations = educations;
    }

    public Set getOptionLogs() {
        return optionLogs;
    }

    public void setOptionLogs(Set optionLogs) {
        this.optionLogs = optionLogs;
    }

    public Set getArticlesForCollectorId() {
        return articlesForCollectorId;
    }

    public void setArticlesForCollectorId(Set articlesForCollectorId) {
        this.articlesForCollectorId = articlesForCollectorId;
    }

    public Set getArticlesForAuthorId() {
        return articlesForAuthorId;
    }

    public void setArticlesForAuthorId(Set articlesForAuthorId) {
        this.articlesForAuthorId = articlesForAuthorId;
    }

    public Set getAttentionsForFollower() {
        return attentionsForFollower;
    }

    public void setAttentionsForFollower(Set attentionsForFollower) {
        this.attentionsForFollower = attentionsForFollower;
    }

    public Set getCommentsForCommentUser() {
        return commentsForCommentUser;
    }

    public void setCommentsForCommentUser(Set commentsForCommentUser) {
        this.commentsForCommentUser = commentsForCommentUser;
    }

    public Set getWorks() {
        return works;
    }

    public void setWorks(Set works) {
        this.works = works;
    }

    public Set getLoginLogs() {
        return loginLogs;
    }

    public void setLoginLogs(Set loginLogs) {
        this.loginLogs = loginLogs;
    }

    public Set getAttentionsForUser() {
        return attentionsForUser;
    }

    public void setAttentionsForUser(Set attentionsForUser) {
        this.attentionsForUser = attentionsForUser;
    }

    public Set getPersonalClassifications() {
        return personalClassifications;
    }

    public void setPersonalClassifications(Set personalClassifications) {
        this.personalClassifications = personalClassifications;
    }

    public Set getCommentsForReplyUser() {
        return commentsForReplyUser;
    }

    public void setCommentsForReplyUser(Set commentsForReplyUser) {
        this.commentsForReplyUser = commentsForReplyUser;
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

    public Set getUserBySendUser() {
        return userBySendUser;
    }

    public void setUserBySendUser(Set userBySendUser) {
        this.userBySendUser = userBySendUser;
    }

    public Set getUserByReceiveUser() {
        return userByReceiveUser;
    }

    public void setUserByReceiveUser(Set userByReceiveUser) {
        this.userByReceiveUser = userByReceiveUser;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        if(httpSessionBindingEvent.getName()=="user"){

        }
    }
}
