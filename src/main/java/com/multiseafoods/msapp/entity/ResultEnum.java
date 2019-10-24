package com.multiseafoods.msapp.entity;

public enum ResultEnum {
    SUCCESS(200,"登陆成功"),
    USERNAME_OR_PASSWORD(-1001,"用户名或密码错误"),
    USER_NOT_FOUND(-1002,"用户不存在"),
    USER_NOT_LOGIN(-1003,"用户未登陆")
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
