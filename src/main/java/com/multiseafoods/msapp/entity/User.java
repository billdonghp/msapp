package com.multiseafoods.msapp.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class User extends BaseEntity {
    @NotEmpty(message ="账号不能为空")
    private String username;
    @NotEmpty(message ="密码不能为空")
    private String password;
}
