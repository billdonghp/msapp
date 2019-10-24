package com.multiseafoods.msapp.mapper;

import com.multiseafoods.msapp.entity.User;
import com.multiseafoods.msapp.utils.MyMapper;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends MyMapper<User> {

    @Select("select * from user where username=#{username}")
    User selByUsersName(User user);

}