package com.spring.boot.coffeine.exception;

import com.google.gson.JsonObject;
import org.springframework.security.core.AuthenticationException;

/**
 * Created by jinz
 */
public class CoffeeineAuthenticationException extends AuthenticationException {
    private int type;
    private JsonObject jsMsg;
    private int code;
    public CoffeeineAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }
    public CoffeeineAuthenticationException(int code, String msg) {
        super(msg);
        this.code = code;
    }
    public CoffeeineAuthenticationException(int code, JsonObject jsMsg) {
        super(jsMsg.toString());
        this.code = code;
    }
    public CoffeeineAuthenticationException(int code, int type, String msg ) {
        super(msg);
        this.type = type;
        this.code = code;
    }
    public CoffeeineAuthenticationException(int code, int type, JsonObject jsMsg ) {
        super(jsMsg.toString());
        this.type = type;
        this.jsMsg = jsMsg;
        this.code = code;
    }

    public int getType() {
        return type;
    }

    public JsonObject getJsMsg() {
        return jsMsg;
    }

    public int getCode() {
        return code;
    }

}

