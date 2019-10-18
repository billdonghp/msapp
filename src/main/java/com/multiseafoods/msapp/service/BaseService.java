package com.multiseafoods.msapp.service;

import com.github.pagehelper.PageHelper;
import com.multiseafoods.msapp.entity.Base;
import com.multiseafoods.msapp.entity.Result;
import com.multiseafoods.msapp.mapper.BaseMapper;
import com.multiseafoods.msapp.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BaseService {
    @Autowired
    private BaseMapper baseMapper;

    public Base get(Base base){
        return baseMapper.selectByPrimaryKey(base.getId());
    }

    public Integer save(Base base){
        base.setUpdatedat(new Date());
        if(base.getId() != null){
            return baseMapper.updateByPrimaryKeySelective(base);
        }
        base.setCreatedat(new Date());
        return baseMapper.insertSelective(base);
    }

    public List<Base> query(Base base){
        if(base.getPage() != null && base.getRows() != null){
            PageHelper.startPage(base.getPage(),base.getRows());
        }
        return baseMapper.selectAll();
    }
}
