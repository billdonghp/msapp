package com.multiseafoods.msapp.controller;

import com.github.pagehelper.PageInfo;
import com.multiseafoods.msapp.authorization.annotation.Authorization;
import com.multiseafoods.msapp.entity.Customer;
import com.multiseafoods.msapp.entity.Result;
import com.multiseafoods.msapp.service.CustomerService;
import com.multiseafoods.msapp.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("customer/")
@Api(tags = "3.客户管理")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    private Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @PostMapping("get")
    @Authorization
    @ApiOperation(value="查询客户",notes="查询")
    @ApiImplicitParam(required = true, name="authorization",value="authorization", dataType = "String", paramType="header")
    public Result get(Customer customer){
        logger.info("getCustomer_id:" + customer.getId());
        return ResultUtil.ok(customerService.get(customer));
    }

    @PostMapping("query")
    @Authorization
    @ApiOperation("客户查询List")
    @ApiImplicitParam(required = true, name="authorization", dataType = "String", paramType="header")
    public Result query(@RequestBody  @ApiParam(required = true,name="客户对象",value="传入JSON") Customer customer){
        List<Customer> customerList = customerService.query(customer);
        if(customerList.isEmpty() || customerList.size() == 0){
            return ResultUtil.ok();
        }
        return ResultUtil.ok(new PageInfo<Customer>(customerList));
    }

    @PostMapping("save")
    @Authorization
    @ApiOperation("保存更新客户")
    @ApiImplicitParam(required = true,name="authorization", value="authorization", paramType="header", dataType="String")
    public Result save(Customer customer){
        if(customerService.save(customer) ==1){
            return ResultUtil.ok();
        }
        return ResultUtil.error(0,"error");
    }

    @PostMapping("delete")
    @Authorization
    @ApiOperation("删除客户信息")
    @ApiImplicitParam(name="authorization",value="authorization", required= true, paramType = "header", dataType = "String")
    public Result delete(Customer customer){
        if(customerService.delete(customer) == 1){
            return ResultUtil.ok();
        }
        return ResultUtil.error(0,"error");
    }
}
