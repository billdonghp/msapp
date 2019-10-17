package com.multiseafoods.msapp.controller;

import com.github.pagehelper.PageInfo;
import com.multiseafoods.msapp.entity.Purchase;
import com.multiseafoods.msapp.entity.Result;
import com.multiseafoods.msapp.service.PurchaseService;
import com.multiseafoods.msapp.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("purchase/")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;
    @RequestMapping("findAll/")
    public Result findAll(Purchase purchase){
        return ResultUtil.ok(new PageInfo<Purchase>(purchaseService.findAll(purchase)));
    }


}
