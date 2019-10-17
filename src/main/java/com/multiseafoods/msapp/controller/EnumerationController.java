package com.multiseafoods.msapp.controller;

import com.multiseafoods.msapp.entity.Enumeration;
import com.multiseafoods.msapp.entity.Result;
import com.multiseafoods.msapp.service.EnumerationService;
import com.multiseafoods.msapp.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("enumeration/")
public class EnumerationController {
    @Autowired
    private EnumerationService enumerationService;

    @GetMapping("get/")
    public Result get(Enumeration enumeration){
        return ResultUtil.ok(enumerationService.get(enumeration));
    }

}
