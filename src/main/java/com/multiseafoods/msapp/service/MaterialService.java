package com.multiseafoods.msapp.service;

import com.multiseafoods.msapp.mapper.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialService {
    @Autowired
    private MaterialMapper materialMapper;

}
