package com.rcswu.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(value={"user"})
public class Work implements Serializable {
    private String workId;
    private User user;
    private Date startDate;
    private Date endDate;
    private String company;
    private String position;
    private String briefing;

    public Work() {
    }

    public Work(User user, Date startDate, Date endDate, String company, String position, String briefing) {
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.company = company;
        this.position = position;
        this.briefing = briefing;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBriefing() {
        return briefing;
    }

    public void setBriefing(String briefing) {
        this.briefing = briefing;
    }
}
