package com.multiseafoods.msapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.multiseafoods.msapp.mapper")
@SpringBootApplication
public class MsappApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsappApplication.class, args);
    }

}
