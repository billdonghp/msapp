package com.multiseafoods.msapp.controller;

import com.multiseafoods.msapp.authorization.annotation.Authorization;
import com.multiseafoods.msapp.authorization.manager.TokenManager;
import com.multiseafoods.msapp.entity.Result;
import com.multiseafoods.msapp.entity.User;
import com.multiseafoods.msapp.service.UserService;
import com.multiseafoods.msapp.utils.ResultUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/")
@Api(tags="9.登陆管理")
public class LoginController {
    @Autowired
    private  UserService userService;
    @Autowired
    private  TokenManager tokenManager;


    @PostMapping("login/")
    public String login(User user) throws Exception{

        if(userService.get(user) != null){
            return tokenManager.createToken(user.getUsername()).toString();
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
