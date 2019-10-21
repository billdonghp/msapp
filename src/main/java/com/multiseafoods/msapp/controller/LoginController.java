package com.multiseafoods.msapp.controller;

import com.multiseafoods.msapp.authorization.manager.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/")
public class LoginController {
    @Autowired
    private TokenManager tokenManager;

    @PostMapping("login/{username}")
    public String login(@PathVariable String username){
        if("20120262".equals(username)){
            return tokenManager.createToken(username).toString();
        }
        return null;
    }

    @PostMapping("logout/{username}")
    public void logout(@PathVariable String username){
        tokenManager.deleteToken(username);
    }
}
