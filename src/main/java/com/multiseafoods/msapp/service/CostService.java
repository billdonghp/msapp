package com.multiseafoods.msapp.service;

import com.multiseafoods.msapp.mapper.CostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CostService {
    @Autowired
    private CostMapper costMaper;

}
