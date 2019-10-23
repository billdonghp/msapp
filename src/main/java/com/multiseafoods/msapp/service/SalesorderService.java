package com.multiseafoods.msapp.service;

import com.github.pagehelper.PageHelper;
import com.multiseafoods.msapp.entity.Salesorder;
import com.multiseafoods.msapp.mapper.SalesorderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SalesorderService {

    private final SalesorderMapper salesorderMpapper;
    @Autowired
    public SalesorderService(SalesorderMapper salesorderMapper){
        this.salesorderMpapper = salesorderMapper;
    }

    public Salesorder get(Salesorder salesorder){
        return salesorderMpapper.selectByPrimaryKey(salesorder.getId());
    }

    public Integer save(Salesorder salesorder){
        salesorder.setUpdatedat(new Date());
        if(salesorder.getId() != null){
            return salesorderMpapper.updateByPrimaryKeySelective(salesorder);
        }
        salesorder.setCreatedat(new Date());
        return salesorderMpapper.insertSelective(salesorder);
    }

    public List<Salesorder> query(Salesorder salesorder){
        if(salesorder.getPage() != null && salesorder.getRows() != null){
            PageHelper.startPage(salesorder.getPage(),salesorder.getRows());
        }
        return salesorderMpapper.selectAll();
    }
}
