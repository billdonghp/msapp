package com.multiseafoods.msapp.service;

import com.multiseafoods.msapp.entity.Enumeration;
import com.multiseafoods.msapp.entity.Result;
import com.multiseafoods.msapp.mapper.EnumerationMapper;
import com.multiseafoods.msapp.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnumerationService {
    @Autowired
    private EnumerationMapper enumerationMapper;

    public  Enumeration get(Enumeration enumeration){
        return enumerationMapper.selectByPrimaryKey(enumeration);
    }

}
