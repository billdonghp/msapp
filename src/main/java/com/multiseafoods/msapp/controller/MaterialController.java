package com.multiseafoods.msapp.controller;

import com.multiseafoods.msapp.service.MaterialService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("material")
@Api(tags="7.部品管理")
public class MaterialController {
    @Autowired
    private MaterialService materialService;

    private static final Logger logger = LoggerFactory.getLogger(MaterialController.class);
}
