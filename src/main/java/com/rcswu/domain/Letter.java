package com.rcswu.domain;

import java.io.Serializable;
import java.util.Date;

public class Letter implements Serializable {
    private String letterId;
    private User userBySendUser;
    private User userByReceiveUser;
    private Date sendDate;
    private String letterContent;

    public Letter() {
    }

    public Letter(User userBySendUser, User userByReceiveUser, Date sendDate, String letterContent) {
        this.userBySendUser = userBySendUser;
        this.userByReceiveUser = userByReceiveUser;
        this.sendDate = sendDate;
        this.letterContent = letterContent;
    }

    public String getLetterId() {
        return letterId;
    }

    public void setLetterId(String letterId) {
        this.letterId = letterId;
    }

    public User getUserBySendUser() {
        return userBySendUser;
    }

    public void setUserBySendUser(User userBySendUser) {
        this.userBySendUser = userBySendUser;
    }

    public User getUserByReceiveUser() {
        return userByReceiveUser;
    }

    public void setUserByReceiveUser(User userByReceiveUser) {
        this.userByReceiveUser = userByReceiveUser;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getLetterContent() {
        return letterContent;
    }

    public void setLetterContent(String letterContent) {
        this.letterContent = letterContent;
    }
}
