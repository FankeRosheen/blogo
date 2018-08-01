package com.example.blogo.myblogo.account.views;

import com.example.blogo.myblogo.account.domain.User;

import java.io.Serializable;

public class TotalUser implements Serializable {
    private boolean flag = false;
    private String message = "";

    @Override
    public String toString() {
        return "TotalUser{" +
                "flag=" + flag +
                ", message='" + message + '\'' +
                ", user=" + user +
                '}';
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TotalUser() {
    }

    public TotalUser(boolean flag, String message, User user) {
        this.flag = flag;
        this.message = message;
        this.user = user;
    }

    private User user = null;
}
