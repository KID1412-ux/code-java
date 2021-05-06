package com.guigu.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.code.pojo.Users;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 21:18
 */
public interface UsersMapper extends BaseMapper<Users> {
    //查询所有商户
    List<Users> selectallmerchant();

    Users userLogin(String userName);

    int insertUser(Users user);
}
