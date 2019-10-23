package com.multiseafoods.msapp.service;

import com.github.pagehelper.PageHelper;
import com.multiseafoods.msapp.entity.Purchase;
import com.multiseafoods.msapp.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseMapper purchaseMapper;

    public List<Purchase> query(Purchase purchase){
        if(purchase.getPage() != null && purchase.getRows() != null){
            PageHelper.startPage(purchase.getPage(),purchase.getRows());
        }
        return purchaseMapper.selectAll();
    }
}
