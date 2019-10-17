package com.multiseafoods.msapp.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Cost extends BaseEntity {

    private String no;

    private String copetype;

    private String objecttype;

    private Float actualamount;

    private Integer settlement;

    private String supplier;

    private Integer status;

    private Date createdat;

    private Date updatedat;


}