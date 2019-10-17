package com.multiseafoods.msapp.controller;

import com.multiseafoods.msapp.service.MaterialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("material")
public class MaterialController {
    @Autowired
    private MaterialService materialService;

    Logger logger = LoggerFactory.getLogger(MaterialController.class);
}
