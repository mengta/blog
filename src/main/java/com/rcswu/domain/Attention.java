package com.rcswu.domain;

import java.io.Serializable;

public class Attention implements Serializable {
    private String attentionId;
    private User userByUser;
    private User userByFollower;

    public Attention() {
    }

    public Attention(User userByUser, User userByFollower) {
        this.userByUser = userByUser;
        this.userByFollower = userByFollower;
    }

    public String getAttentionId() {
        return attentionId;
    }

    public void setAttentionId(String attentionId) {
        this.attentionId = attentionId;
    }

    public User getUserByUser() {
        return userByUser;
    }

    public void setUserByUser(User userByUser) {
        this.userByUser = userByUser;
    }

    public User getUserByFollower() {
        return userByFollower;
    }

    public void setUserByFollower(User userByFollower) {
        this.userByFollower = userByFollower;
    }
}
