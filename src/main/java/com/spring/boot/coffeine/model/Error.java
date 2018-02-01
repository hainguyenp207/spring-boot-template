package com.spring.boot.coffeine.model;


/**
 * Created by hainguyen on 6/30/17.
 */
public class Error extends Response{

    private String traceMsg;
    public Error() {
        setErrorCode(0);
    }
    public Error(int errorCode, String message){
        super();
        setErrorCode(errorCode);
        setMessage(message);
    }

    public Error(int errorCode, String message, String traceMsg) {
        setErrorCode(errorCode);
        setMessage(message);
        this.traceMsg = traceMsg;
    }

    public boolean isValid() {
        return getErrorCode() == 0;
    }
    public boolean isInValid() {
        return !isValid();
    }

    public String getTraceMsg() {
        return traceMsg;
    }

    public void setTraceMsg(String traceMsg) {
        this.traceMsg = traceMsg;
    }
}
