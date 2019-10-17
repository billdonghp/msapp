package com.multiseafoods.msapp.controller;

import com.multiseafoods.msapp.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cost/")
public class CostController {
    @Autowired
    private CostService costService;

}
