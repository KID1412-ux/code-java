package com.guigu.code.controller;

import com.guigu.code.pojo.Users;
import com.guigu.code.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping("userLogin")
    @ResponseBody
    public Users userLogin(String userName, String password){
        return userService.userLogin(userName, password);
    }

    /**
     * 查询单个用户（可用于用户验证）
     * @param userName
     * @return
     */
    @RequestMapping("selectOneUser")
    @ResponseBody
    public Users selectOneUser(String userName){
        return userService.selectOneUser(userName);
    }
    @RequestMapping("insertUser")
    @ResponseBody
    public int insertUser(Users user){
        return userService.insertUser(user);
    }
}
