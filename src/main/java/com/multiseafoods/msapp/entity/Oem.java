package com.multiseafoods.msapp.entity;

import lombok.Data;

@Data
public class Oem extends BaseEntity {
    private String no;

    private String material;

    private Integer weight;

    private Integer qty;

    private Integer finweight;

    private Integer finqty;

    private Integer status;

    private Float oemfee;

    private Integer resqty;

}