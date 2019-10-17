package com.multiseafoods.msapp.controller;

import com.multiseafoods.msapp.service.SalesorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("salesorder/")
public class SalesorderController {
    @Autowired
    private SalesorderService salesorderService;

}
