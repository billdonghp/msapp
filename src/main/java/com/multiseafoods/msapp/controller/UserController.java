package com.multiseafoods.msapp.controller;

import com.multiseafoods.msapp.entity.Result;
import com.multiseafoods.msapp.entity.User;
import com.multiseafoods.msapp.service.UserService;
import com.multiseafoods.msapp.utils.ResultUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/")
@Api(tags = "10.用户册")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    public Result save(User user){
        if(userService.save(user) == 1){
            return ResultUtil.ok();
        }
        return ResultUtil.error(0,"error");
    }

}
