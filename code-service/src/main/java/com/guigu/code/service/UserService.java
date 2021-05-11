package com.guigu.code.service;

import com.guigu.code.pojo.Loginformation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.code.pojo.Users;

import java.util.List;

public interface UserService extends IService<Users> {

    Users userLogin (String userName,String password);

    int insertUser(Users user);

    Users selectOneUser(String userName);
    //查询所有的商户审核信息
    List<Users> selectallmerchant();

    //通过商户审核
    int pass(Integer id);
    //不通过商户审核
    int fail(Integer id);
    //查询所有商户
    List<Users> selectmerchant();
    //通过商户ID查询商户
    Users selectbymerchantId(Integer id);
    //修改商户信息
    int updatemerchant(Users users);


    //查询所有供应商审核信息
    List<Users> selectallsupplier();
    //通过供应商审核
    int  passsupplier(Integer id);
    //不通过供应商审核
    int failsupplier(Integer id);
    //查询所有供应商
    List<Users> selectsupplier();
    //根据ID查询供应商
    Users selectsupplierbyid(Integer id);
    //修改供应商信息
    int updatesupplier(Users users);

    //不通过反馈信息
    int insertloginformation(Loginformation log);
}
