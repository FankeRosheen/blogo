package com.example.blogo.myblogo.account.views;

import java.io.Serializable;

public class ResponseMessage implements Serializable {
    private boolean flag = false;
    private String message = "";

    public ResponseMessage(boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public boolean getFlag() {
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

    public ResponseMessage() {
    }
}
