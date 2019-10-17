package com.multiseafoods.msapp.controller;

import com.github.pagehelper.PageInfo;
import com.multiseafoods.msapp.entity.Customer;
import com.multiseafoods.msapp.entity.Result;
import com.multiseafoods.msapp.service.CustomerService;
import com.multiseafoods.msapp.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("customer/")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    private Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @RequestMapping("get/{id}")
    public Result getCustomer(@PathVariable Long id){
        logger.info("getCustomer_id:" + id);
        //return null;
        return ResultUtil.ok(customerService.get(id));
    }

    @RequestMapping("findAll")
    public Result findAll(Customer customer){
        List<Customer> customerList = customerService.getAll(customer);
        return ResultUtil.ok(new PageInfo<Customer>(customerList));
    }
}
