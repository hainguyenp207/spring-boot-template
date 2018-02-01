package com.spring.boot.coffeine.model;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

public class Request implements Serializable{
    @NotBlank
    private String requestId;
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
