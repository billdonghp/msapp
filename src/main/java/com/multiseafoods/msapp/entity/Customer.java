package com.multiseafoods.msapp.entity;

import lombok.Data;

@Data
public class Customer extends BaseEntity {

    private String name;

    private String mobilephone;

    private String address;

    private String remark;

    private Integer status;

}