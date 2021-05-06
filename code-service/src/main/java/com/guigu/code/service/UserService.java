package com.guigu.code.service;

import com.guigu.code.pojo.Users;

public interface UserService {

    Users userLogin (String userName,String password);

    int insertUser(Users user);

    Users selectOneUser(String userName);
}
