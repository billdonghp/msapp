package com.multiseafoods.msapp.controller;

import com.github.pagehelper.PageInfo;
import com.multiseafoods.msapp.authorization.annotation.Authorization;
import com.multiseafoods.msapp.entity.Cost;
import com.multiseafoods.msapp.entity.Result;
import com.multiseafoods.msapp.service.CostService;
import com.multiseafoods.msapp.utils.ResultUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cost/")
@Api(tags="5.费用管理")
public class CostController {
    @Autowired
    private CostService costService;

    @PostMapping("get")
    @Authorization
    public Result get(Cost cost){
        return ResultUtil.ok(costService.get(cost));
    }

    @PostMapping("save")
    @Authorization
    public Result save(Cost cost){
        if(costService.save(cost) == 1) {
            return ResultUtil.ok();
        }
        return ResultUtil.error(0,"error");
    }

    @PostMapping("query")
    @Authorization
    public Result query(Cost cost){
        return ResultUtil.ok(new PageInfo<Cost>(costService.query(cost)));
    }

}
