package com.multiseafoods.msapp.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Customer extends BaseEntity {

    private String name;

    private String mobilephone;

    private String address;

    private String remark;

    private Integer status;

    private Date createdat;

    private Date updatedat;

}