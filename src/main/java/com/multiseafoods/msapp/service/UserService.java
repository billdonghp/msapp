package com.multiseafoods.msapp.service;

import com.multiseafoods.msapp.entity.User;
import com.multiseafoods.msapp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public Integer save(User user){
        user.setUpdatedat(new Date());
        if(user.getId() != null){
           return userMapper.updateByPrimaryKeySelective(user);
        }
        user.setCreatedat(new Date());
        return  userMapper.insertSelective(user);
    }

    public User get(User user){
        return userMapper.selectOne(user);
    }

}
