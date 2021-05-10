package com.guigu.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.code.pojo.Users;

public interface UserService extends IService<Users> {

    Users userLogin(String userName, String password);

    int insertUser(Users user);

    Users selectOneUser(String userName);
}
