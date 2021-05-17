package com.guigu.code.controller;

import com.guigu.code.pojo.Loginformation;
import com.guigu.code.pojo.Users;
import com.guigu.code.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    public Users userLogin(String userName, String password) {
        return userService.userLogin(userName, password);
    }

    /**
     * 查询单个用户（可用于用户验证）
     *
     * @param userName
     * @return
     */
    @RequestMapping("selectOneUser")
    @ResponseBody
    public Users selectOneUser(String userName) {
        return userService.selectOneUser(userName);
    }

    @RequestMapping("insertUser")
    @ResponseBody
    public int insertUser(Users user) {
        return userService.insertUser(user);
    }

    /*查询所有商户审核信息*/
    /*查询所有供应商审核信息*/
    @RequestMapping("selectallmerchant")
    @ResponseBody
    public List<Users> selectallmerchant() {
        List<Users> users = userService.selectallmerchant();
        return users;
    }

    /*通过商户审核*/
    @RequestMapping("pass")
    @ResponseBody
    public String pass(Integer id) {
        int pass = userService.pass(id);
        return "成功";
    }

    /*不通过商户审核*/
    @RequestMapping("fail")
    @ResponseBody
    public String fail(Integer id) {
        int pass = userService.fail(id);
        return "成功";
    }

    @RequestMapping("selectmerchant")
    @ResponseBody
    /*查询所有商户*/
    public List<Users> selectmerchant() {
        List<Users> list = userService.selectmerchant();
        return list;
    }

    @RequestMapping("selectbymerchantId")
    @ResponseBody
    /*根据商户ID查询商户*/
    public Users selectbymerchantId(Integer id) {
        Users users = userService.selectbymerchantId(id);
        return users;
    }

    @RequestMapping("updatemerchant")
    @ResponseBody
    /*修改商户信息*/
    public String updatemerchant(Users users) {
        System.out.println(users);
        int updatemerchant = userService.updatemerchant(users);
        return "修改成功";
    }

    @RequestMapping("passsupplier")
    @ResponseBody
    /*通过供应商审核*/
    public String passsupplier(Integer id) {
        int passsupplier = userService.passsupplier(id);
        return "成功";
    }

    /*不通过供应商审核*/
    @RequestMapping("failsupplier")
    @ResponseBody
    public String failsupplier(Integer id) {
        int failsupplier = userService.failsupplier(id);
        return "不通过";
    }

    /*查询所有供应商审核信息*/
    @RequestMapping("selectallsupplier")
    @ResponseBody
    public List<Users> selectallsupplier() {
        List<Users> users = userService.selectallsupplier();
        return users;
    }

    /*查询所有的供应商*/
    @RequestMapping("selectsupplier")
    @ResponseBody
    public List<Users> selectsupplier() {
        List<Users> users = userService.selectsupplier();
        return users;
    }

    /*根据ID查询供应商*/
    @RequestMapping("selectsupplierbyid")
    @ResponseBody
    public Users selectsupplierbyid(Integer id) {
        Users users = userService.selectsupplierbyid(id);
        return users;
    }

    /*修改供应商信息*/
    @RequestMapping("updatesupplier")
    @ResponseBody
    public String updatesupplier(Users users) {
        int updatesupplier = userService.updatesupplier(users);
        return "修改成功";
    }

    /*不通过反馈信息*/
    @RequestMapping("insertloginformation")
    @ResponseBody
    public String insertloginformation(Loginformation log) {
        System.out.println(log);
        int i = userService.insertloginformation(log);
        return "成功";
    }

    //通过ID查询用户
    @RequestMapping("selectUserByID")
    @ResponseBody
    public Users selectUserByID(String userID) {
        Integer ID = Integer.parseInt(userID);
        Users users = userService.selectUserById(ID);

        System.out.println("aaaaaaaaaaaaaaaaaa");
        System.out.println(users);
        System.out.println("aaaaaaaaaaaaaaaaaa");

        return users;
    }
}
