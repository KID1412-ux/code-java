package com.guigu.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.code.pojo.Users;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 21:18
 */
public interface UsersMapper extends BaseMapper<Users> {
    //查询所有商户审核信息
    List<Users> selectallmerchant();

    Users userLogin(String userName);

    int insertUser(Users user);

    //通过商户审核
    int pass(Integer id);
    //不通过商户审核
    int fail(Integer id);
    //查询所有商户
    List<Users> selectmerchant();
    //根据商户ID查询商户
    Users selectbymerchantId(Integer id);

    int updatemerchant(Users users);
}
