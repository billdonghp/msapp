package com.multiseafoods.msapp.entity;

import lombok.Data;

@Data
public class Salesorder extends BaseEntity {

    private String material;

    private Integer qty;

    private String weight;

    private Float carryfee;

    private Float total;

    private Float price;

    private Float amount;

    private Integer status;

    private String remark;

}