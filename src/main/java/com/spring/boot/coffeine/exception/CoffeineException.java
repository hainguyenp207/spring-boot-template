package com.spring.boot.coffeine.exception;

import com.spring.boot.coffeine.constant.ErrorCode;
import com.spring.boot.coffeine.model.Error;
import org.springframework.stereotype.Component;

/**
 * Created by jinz
 */
@Component
public class CoffeineException extends Exception {
    private Error error;


    public CoffeineException() {
        super();
    }

    public CoffeineException(Error error) {
        super(error.getMessage());
        this.error = error;
    }


    public CoffeineException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.error = new Error();
        error.setErrorCode(errorCode.getCode());
        error.setMessage(errorCode.getMessage());
        error.setLocalMessage(errorCode.getLocalMessage());
    }

    public Error getError() {
        return error;
    }
}
