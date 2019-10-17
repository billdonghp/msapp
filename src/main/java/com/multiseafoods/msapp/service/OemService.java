package com.multiseafoods.msapp.service;

import com.multiseafoods.msapp.mapper.OemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OemService {
    @Autowired
    private OemMapper oemMapper;

}
