package com.rcswu.domain;

import java.io.Serializable;
import java.util.Date;

public class Education implements Serializable {
    private String educationId;
    private User user;
    private Date startDate;
    private Date endDate;
    private String education;
    private String school;
    private String professional;

    public Education() {
    }

    public Education(User user, Date startDate, Date endDate, String education, String school, String professional) {
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.education = education;
        this.school = school;
        this.professional = professional;
    }

    public String getEducationId() {
        return educationId;
    }

    public void setEducationId(String educationId) {
        this.educationId = educationId;
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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }
}
