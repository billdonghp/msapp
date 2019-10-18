package com.multiseafoods.msapp.controller;

import com.github.pagehelper.PageInfo;
import com.multiseafoods.msapp.entity.Customer;
import com.multiseafoods.msapp.entity.Result;
import com.multiseafoods.msapp.service.CustomerService;
import com.multiseafoods.msapp.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("customer/")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    private Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @PostMapping("get")
    public Result getCustomer(Customer customer){
        logger.info("getCustomer_id:" + customer.getId());
        return ResultUtil.ok(customerService.get(customer));
    }

    @PostMapping("query")
    public Result query(Customer customer){
        List<Customer> customerList = customerService.query(customer);
        return ResultUtil.ok(new PageInfo<Customer>(customerList));
    }

    @PostMapping("save")
    public Result save(Customer customer){
        if(customerService.save(customer) ==1){
            return ResultUtil.ok();
        }
        return ResultUtil.error(0,"error");
    }
}
