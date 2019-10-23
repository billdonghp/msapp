package com.multiseafoods.msapp.entity;

import lombok.Data;

@Data
public class User extends BaseEntity {
    private String username;
    private String password;
}
