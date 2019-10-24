package com.multiseafoods.msapp.service;

import com.multiseafoods.msapp.authorization.manager.TokenManager;
import com.multiseafoods.msapp.authorization.model.TokenModel;
import com.multiseafoods.msapp.entity.ResultEnum;
import com.multiseafoods.msapp.entity.User;
import com.multiseafoods.msapp.exception.CustException;
import com.multiseafoods.msapp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TokenManager tokenManager;

    public Integer save(User user){
        user.setUpdatedat(new Date());
        if(user.getId() != null){
           return userMapper.updateByPrimaryKeySelective(user);
        }
        user.setCreatedat(new Date());
        return  userMapper.insertSelective(user);
    }

    public void login(User user) throws Exception{
        User t = userMapper.selByUsersName(user);
        //userMapper.selectOneByExample()
        System.out.println(t);
        if(t == null){
            throw new CustException(ResultEnum.USER_NOT_FOUND);
        }
        if(!user.getPassword().equals(t.getPassword())){
            throw new CustException(ResultEnum.USERNAME_OR_PASSWORD);
        }

        throw new CustException(ResultEnum.SUCCESS,tokenManager.createToken(t.getUsername()).toString());
    }

}
