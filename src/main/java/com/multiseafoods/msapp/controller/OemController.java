package com.multiseafoods.msapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ome/")
public class OemController {
    @GetMapping("get/{id}")
    public void get(@PathVariable Integer id){

    }
}
