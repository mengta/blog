package com.rcswu.domain;

import java.io.Serializable;
import java.util.Date;

public class OptionLog implements Serializable {
    private String optionId;
    private User user;
    private String optionUsername;
    private Date optionDate;
    private String optionMethod;
    private String optionClass;
    private String optionMessage;

    public OptionLog() {
    }

    public OptionLog(User user, String optionUsername, Date optionDate, String optionMethod, String optionClass, String optionMessage) {
        this.user = user;
        this.optionUsername = optionUsername;
        this.optionDate = optionDate;
        this.optionMethod = optionMethod;
        this.optionClass = optionClass;
        this.optionMessage = optionMessage;
    }

    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOptionUsername() {
        return optionUsername;
    }

    public void setOptionUsername(String optionUsername) {
        this.optionUsername = optionUsername;
    }

    public Date getOptionDate() {
        return optionDate;
    }

    public void setOptionDate(Date optionDate) {
        this.optionDate = optionDate;
    }

    public String getOptionMethod() {
        return optionMethod;
    }

    public void setOptionMethod(String optionMethod) {
        this.optionMethod = optionMethod;
    }

    public String getOptionClass() {
        return optionClass;
    }

    public void setOptionClass(String optionClass) {
        this.optionClass = optionClass;
    }

    public String getOptionMessage() {
        return optionMessage;
    }

    public void setOptionMessage(String optionMessage) {
        this.optionMessage = optionMessage;
    }
}
