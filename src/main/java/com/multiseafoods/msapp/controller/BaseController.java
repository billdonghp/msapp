package com.multiseafoods.msapp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.multiseafoods.msapp.entity.Base;
import com.multiseafoods.msapp.entity.Result;
import com.multiseafoods.msapp.service.BaseService;
import com.multiseafoods.msapp.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("base/")
public class BaseController {
    @Autowired
    private BaseService baseService;

    @GetMapping("get")
    public Result get(Base base){
        return ResultUtil.ok(baseService.get(base));
    }

    @PostMapping("save")
    public Result save(Base base){
        return ResultUtil.ok(baseService.save(base));
    }

    @GetMapping("query")
    public Result query(Base base){
       return ResultUtil.ok( new PageInfo<Base>(baseService.query(base)));
    }


}
