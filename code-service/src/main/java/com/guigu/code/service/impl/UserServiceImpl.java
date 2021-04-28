package com.guigu.code.service.impl;

import com.guigu.code.pojo.Users;
import com.guigu.code.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public Users userLogin(String userName, String password) {
        return null;
    }

    @Override
    public int register(Users user) {
        return 0;
    }
}
