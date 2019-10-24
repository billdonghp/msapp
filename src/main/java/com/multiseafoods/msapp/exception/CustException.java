package com.multiseafoods.msapp.exception;

import com.multiseafoods.msapp.entity.ResultEnum;

public class CustException extends RuntimeException{
    private Integer code;
    private Object data;
    public CustException(ResultEnum resultenum) {
        super(resultenum.getMsg());
        this.code = resultenum.getCode();
    }
    public CustException(ResultEnum resultenum,Object data) {
        super(resultenum.getMsg());
        this.code = resultenum.getCode();
        this.data = data;
    }



    public Integer getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }
}

