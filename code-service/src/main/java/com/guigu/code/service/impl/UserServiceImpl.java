package com.guigu.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.code.mapper.UsersMapper;
import com.guigu.code.pojo.Users;
import com.guigu.code.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UsersMapper, Users> implements UserService {
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public Users userLogin(String userName, String password) {
        Users users = usersMapper.userLogin(userName);
        if (users!=null) {
            if (password.equals(users.getPassword()) ) {
                return users;
            }
        }
        return null;
    }

    @Override
    public int insertUser(Users user) {
        user.setUserNickname(user.getUserName());
        user.setType("0");
        user.setUserStats("0");
        return usersMapper.insertUser(user);
    }

    @Override
    public Users selectOneUser(String userName) {
        Users users = usersMapper.userLogin(userName);
        if (users!=null) {
            return users;
        }
        return null;
    }

    @Override
    public List<Users> selectallmerchant() {
        List<Users> users = usersMapper.selectallmerchant();
        return users;
    }

    @Override
    public int pass(Integer id) {
        return usersMapper.pass(id);
    }

    @Override
    public int fail(Integer id) {
        return usersMapper.fail(id);
    }

    @Override
    public List<Users> selectmerchant() {
        List<Users> list = usersMapper.selectmerchant();
        return list;
    }

    @Override
    public Users selectbymerchantId(Integer id) {
        return usersMapper.selectbymerchantId(id);
    }

    @Override
    public int updatemerchant(Users users) {
        return usersMapper.updatemerchant(users);
    }
}
