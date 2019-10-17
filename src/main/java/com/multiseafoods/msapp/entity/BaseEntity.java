package com.multiseafoods.msapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
public class BaseEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Transient
    private Integer page = 1;
    @Transient
    private Integer rows = 10;

}
