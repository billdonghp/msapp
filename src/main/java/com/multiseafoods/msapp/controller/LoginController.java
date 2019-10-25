package com.multiseafoods.msapp.controller;

import com.multiseafoods.msapp.authorization.annotation.Authorization;
import com.multiseafoods.msapp.authorization.manager.TokenManager;
import com.multiseafoods.msapp.entity.Result;
import com.multiseafoods.msapp.entity.User;
import com.multiseafoods.msapp.service.UserService;
import com.multiseafoods.msapp.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("user/")
@Api(tags="9.登陆管理")
public class LoginController {
    @Autowired
    private  UserService userService;
    @Autowired
    private  TokenManager tokenManager;


    @PostMapping("login/")
    @ApiOperation("登陆")
    public void login(User user) throws Exception{
        userService.login(user);
    }

    @PostMapping("logout/{username}")
    @ApiOperation("注销")
    public Result logout(@PathVariable String username){
        tokenManager.deleteToken(username);
        return ResultUtil.ok();
    }

    @PostMapping("checktoken")
    @Authorization
    @ApiOperation("验证Token")
    public Result checkToken(){
        return ResultUtil.ok();
    }

    @PostMapping("register")
    @ApiOperation("注册用户")
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
