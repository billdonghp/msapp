package com.multiseafoods.msapp.controller;

import com.github.pagehelper.PageInfo;
import com.multiseafoods.msapp.authorization.annotation.Authorization;
import com.multiseafoods.msapp.entity.Base;
import com.multiseafoods.msapp.entity.Result;
import com.multiseafoods.msapp.service.BaseService;
import com.multiseafoods.msapp.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("base/")
public class BaseController {
    @Autowired
    private BaseService baseService;

    @PostMapping("get")
    public Result get(Base base){
        return ResultUtil.ok(baseService.get(base));
    }

    @PostMapping("save")
    public Result save(Base base){
        return ResultUtil.ok(baseService.save(base));
    }

    @PostMapping("query")
    @Authorization
    public Result query(Base base){
       return ResultUtil.ok( new PageInfo<Base>(baseService.query(base)));
    }
}
