package com.multiseafoods.msapp.controller;

import com.multiseafoods.msapp.authorization.annotation.Authorization;
import com.multiseafoods.msapp.authorization.manager.TokenManager;
import com.multiseafoods.msapp.entity.Result;
import com.multiseafoods.msapp.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/")
public class LoginController {

    private final TokenManager tokenManager;
    @Autowired
    public LoginController(TokenManager tokenManager){
        this.tokenManager = tokenManager;
    }

    @PostMapping("login/{username}")
    public String login(@PathVariable String username){
        if("20120262".equals(username)){
            return tokenManager.createToken(username).toString();
        }
        return null;
    }

    @PostMapping("logout/{username}")
    public Result logout(@PathVariable String username){
        tokenManager.deleteToken(username);
        return ResultUtil.ok();
    }

    @PostMapping("checktoken")
    @Authorization
    public Result checkToken(){
        return ResultUtil.ok();
    }
}
