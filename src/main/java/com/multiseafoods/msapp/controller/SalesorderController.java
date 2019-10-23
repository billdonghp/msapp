package com.multiseafoods.msapp.controller;

import com.github.pagehelper.PageInfo;
import com.multiseafoods.msapp.authorization.annotation.Authorization;
import com.multiseafoods.msapp.entity.Result;
import com.multiseafoods.msapp.entity.Salesorder;
import com.multiseafoods.msapp.service.SalesorderService;
import com.multiseafoods.msapp.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("salesorder/")
@Api(tags="2.销售管理")
public class SalesorderController {
    @Autowired
    private SalesorderService salesorderService;

    @PostMapping("get")
    @Authorization
    @ApiImplicitParam(name = "authorization", required = true, dataType = "String", paramType = "header")
    public Result get(Salesorder salesorder){
        return ResultUtil.ok(salesorderService.get(salesorder));
    }

    @PostMapping("query")
    @Authorization
    @ApiImplicitParam(name = "authorization", required = true,dataType = "String", paramType = "header")
    public Result query(Salesorder salesorder){
        return ResultUtil.ok(new PageInfo(salesorderService.query(salesorder)));
    }

    @PostMapping("save")
    @Authorization
    @ApiImplicitParam(name = "authorization", required = true, dataType = "String", paramType = "header")
    public Result save(Salesorder salesorder){
        return ResultUtil.ok(salesorderService.save(salesorder));
    }

}
