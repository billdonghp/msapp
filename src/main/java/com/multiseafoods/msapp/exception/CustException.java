package com.multiseafoods.msapp.exception;

import com.multiseafoods.msapp.entity.ResultEnum;

public class CustException extends RuntimeException{
    private Integer code;

    public CustException(ResultEnum resultenum) {
        super(resultenum.getMsg());
        this.code = resultenum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}

