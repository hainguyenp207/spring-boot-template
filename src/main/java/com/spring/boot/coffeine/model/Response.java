package com.spring.boot.coffeine.model;

import com.spring.boot.coffeine.constant.ErrorCode;

public abstract class Response {
    private int errorCode = 0;
    private String message;
    private String localMessage;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        if(message == null)
            return ErrorCode.findByCode(errorCode).getMessage();
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLocalMessage() {
        return localMessage;
    }

    public void setLocalMessage(String localMessage) {
        this.localMessage = localMessage;
    }
}