package com.multiseafoods.msapp.exception;

public class CustException extends RuntimeException{
    private Integer code;

    public CustException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}

