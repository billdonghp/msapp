package com.multiseafoods.msapp.controller;

import com.multiseafoods.msapp.entity.Result;
import com.multiseafoods.msapp.entity.User;
import com.multiseafoods.msapp.service.UserService;
import com.multiseafoods.msapp.utils.ResultUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("user/")
@Api(tags = "10.用户册")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    public Result save(@Valid User user, BindingResult bindResult){
        if(bindResult.hasErrors()){
            return ResultUtil.error(0,bindResult.getFieldError().getDefaultMessage());
        }
        if(userService.save(user) == 1){
            return ResultUtil.ok();
        }
        return ResultUtil.error(-1,"未知错误，请联系管理员");
    }

}
