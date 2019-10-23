package com.multiseafoods.msapp.controller;

import com.github.pagehelper.PageInfo;
import com.multiseafoods.msapp.authorization.annotation.Authorization;
import com.multiseafoods.msapp.entity.Purchase;
import com.multiseafoods.msapp.entity.Result;
import com.multiseafoods.msapp.service.PurchaseService;
import com.multiseafoods.msapp.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("purchase/")
@Api(tags="1.采购管理")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;
    @PostMapping("query/")
    @ApiOperation(value = "查询采购订单")
    @Authorization
    @ApiImplicitParam(name="authorization",required = true,dataType = "String", paramType = "header")
    public Result query(Purchase purchase){
        return ResultUtil.ok(new PageInfo<Purchase>(purchaseService.query(purchase)));
    }


}
