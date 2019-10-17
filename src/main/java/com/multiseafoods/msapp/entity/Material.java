package com.multiseafoods.msapp.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Material extends BaseEntity {

    private String name;

    private String objecttype;

    private Date createdat;

    private Date updatedat;
}