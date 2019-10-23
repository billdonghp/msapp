package com.multiseafoods.msapp.controller;

import com.multiseafoods.msapp.authorization.annotation.Authorization;
import com.multiseafoods.msapp.entity.Enumeration;
import com.multiseafoods.msapp.entity.Result;
import com.multiseafoods.msapp.service.EnumerationService;
import com.multiseafoods.msapp.utils.ResultUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("enumeration/")
@Api(tags="8.枚举管理")
public class EnumerationController {
    @Autowired
    private EnumerationService enumerationService;

    @PostMapping("get/")
    @Authorization
    public Result get(Enumeration enumeration){
        return ResultUtil.ok(enumerationService.get(enumeration));
    }

}
