package com.rcswu.domain;

import java.io.Serializable;
import java.util.Date;

public class LoginLog implements Serializable {
    private String loginId;
    private User user;
    private String loginUsername;
    private Date loginDate;
    private String loginIp;

    public LoginLog() {
    }

    public LoginLog(User user, String loginUsername, Date loginDate, String loginIp) {
        this.user = user;
        this.loginUsername = loginUsername;
        this.loginDate = loginDate;
        this.loginIp = loginIp;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }
}
