package com.multiseafoods.msapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
public class BaseEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private Integer page = 1;

    @Transient
    private Integer rows = 10;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date createdat;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date updatedat;
}
