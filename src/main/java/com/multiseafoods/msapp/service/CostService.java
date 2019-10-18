package com.multiseafoods.msapp.service;

import com.github.pagehelper.PageHelper;
import com.multiseafoods.msapp.entity.Cost;
import com.multiseafoods.msapp.mapper.CostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CostService {
    @Autowired
    private CostMapper costMapper;

    public Cost get(Cost cost){
       return costMapper.selectByPrimaryKey(cost.getId());
    }

    public Integer save(Cost cost){
        cost.setUpdatedat(new Date());
        if(cost.getId() != null){
            return costMapper.updateByPrimaryKeySelective(cost);
        }
        cost.setCreatedat(new Date());
        return costMapper.insertSelective(cost);
    }

    public List<Cost> query(Cost cost){
        if(cost.getPage() != null && cost.getRows() != null){
            PageHelper.startPage(cost.getPage(),cost.getRows());
        }
        return costMapper.selectAll();
    }

}
