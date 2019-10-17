package com.multiseafoods.msapp.service;

import com.github.pagehelper.PageHelper;
import com.multiseafoods.msapp.entity.Customer;
import com.multiseafoods.msapp.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    public Customer get(Long id){
        return customerMapper.selectByPrimaryKey(id);
    }

    public List<Customer> getAll(Customer customer){
        if(customer.getPage() != null && customer.getRows() != null){
            PageHelper.startPage(customer.getPage(),customer.getRows());
        }
        return customerMapper.selectAll();
    }

}
