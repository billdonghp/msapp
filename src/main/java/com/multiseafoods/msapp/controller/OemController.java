package com.multiseafoods.msapp.controller;

import com.multiseafoods.msapp.authorization.annotation.Authorization;
import com.multiseafoods.msapp.entity.Oem;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ome/")
@Api(tags="4.OEM管理")
public class OemController {
    @PostMapping("get")
    @Authorization
    public void get(Oem oem){

    }
}
