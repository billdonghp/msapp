package com.multiseafoods.msapp.service;

import com.github.pagehelper.PageHelper;
import com.multiseafoods.msapp.entity.Customer;
import com.multiseafoods.msapp.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    public Customer get(Customer customer){
        return customerMapper.selectByPrimaryKey(customer.getId());
    }

    public List<Customer> query(Customer customer){
        if(customer.getPage() != null && customer.getRows() != null){
            PageHelper.startPage(customer.getPage(),customer.getRows());
        }
        return customerMapper.selectAll();
    }

    public Integer save(Customer customer){
        customer.setUpdatedat(new Date());
        if(customer.getId() != null){
            return customerMapper.updateByPrimaryKeySelective(customer);
        }
        customer.setCreatedat(new Date());
        return customerMapper.insertSelective(customer);
    }


}
