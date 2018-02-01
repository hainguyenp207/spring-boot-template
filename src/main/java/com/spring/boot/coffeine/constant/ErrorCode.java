/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.coffeine.constant;

public enum ErrorCode {
	SUCCESS(0, "Success", ""),
	SERVICE_MAINTENANCE(29, "Service maintenance", ""),
	REQUEST_EXPIRED(30, "Request expried", ""),
	SYSTEM_ERROR(99, "Unexpected Error", "");

	private final int code;
	private final String message;
	private final String localMessage;

	ErrorCode(int code, String message, String localMessage) {
		this.code = code;
		this.message = message;
		this.localMessage = localMessage;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

    public String getLocalMessage() {
        return localMessage;
    }

    public static ErrorCode findByCode(int code) {
		for (ErrorCode type : values()) {
			if (type.getCode() == code) {
				return type;
			}
		}
		return SYSTEM_ERROR;
	}
}
