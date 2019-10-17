package com.multiseafoods.msapp.service;

import com.multiseafoods.msapp.entity.Base;
import com.multiseafoods.msapp.entity.Result;
import com.multiseafoods.msapp.mapper.BaseMapper;
import com.multiseafoods.msapp.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseService {
    @Autowired
    private BaseMapper baseMapper;

    public Result get(Base base){
        return ResultUtil.ok(baseMapper.selectByPrimaryKey(base.getId()));
    }
}
