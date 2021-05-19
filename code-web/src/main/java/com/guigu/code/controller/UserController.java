package com.guigu.code.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guigu.code.pojo.Goods;
import com.guigu.code.pojo.Loginformation;
import com.guigu.code.pojo.Users;
import com.guigu.code.service.LogInformationService;
import com.guigu.code.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private LogInformationService logInformationService;

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping("userLogin")
    
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
    
    public Users selectOneUser(String userName) {
        return userService.selectOneUser(userName);
    }

    @RequestMapping("insertUser")
    public int insertUser(Users user) {
        return userService.insertUser(user);
    }
    @RequestMapping("updateUser")
    public boolean updateUser(Users user, MultipartFile userImageUrl, HttpServletRequest request) {
        System.out.println(user);
        if (userImageUrl != null) {
            //获取当前项目发布地址/img
            String path = request.getServletContext().getRealPath("/img/users");
            try {
                userImageUrl.transferTo(new File(path, userImageUrl.getOriginalFilename()));
                user.setUserImage("img/users/" + userImageUrl.getOriginalFilename());
            } catch (IOException e) {
            }
        }
        boolean result = this.userService.updateById(user);
        return result;
    }
    /*查询所有商户审核信息*/
    /*查询所有供应商审核信息*/
    @RequestMapping("selectallmerchant")
    public List<Users> selectallmerchant() {
        List<Users> users = userService.selectallmerchant();
        return users;
    }
    //商户申请
    @RequestMapping("merchantApply")
    public boolean merchantApply(Users user, MultipartFile fileObj1, MultipartFile fileObj2, HttpServletRequest request) {
        System.out.println(user);
        if (fileObj1 != null&&fileObj2!=null) {
            //获取当前项目发布地址/img
            String path = request.getServletContext().getRealPath("/img/users");
            try {
                fileObj1.transferTo(new File(path, fileObj1.getOriginalFilename()));
                user.setMerchantShopImage("img/users/" + fileObj1.getOriginalFilename());
                fileObj2.transferTo(new File(path, fileObj2.getOriginalFilename()));
                user.setMerchantPermitImage("img/users/" + fileObj2.getOriginalFilename());
            } catch (IOException e) {
            }
        }
        user.setMerchantAuditStatus("0");
        boolean result = this.userService.updateById(user);
        return result;
    }
    //供应商申请
    @RequestMapping("supplierApply")
    public boolean supplierApply(Users user, MultipartFile fileObj3, MultipartFile fileObj4, HttpServletRequest request) {
        System.out.println(user);
        if (fileObj3 != null&&fileObj4!=null) {
            //获取当前项目发布地址/img
            String path = request.getServletContext().getRealPath("/img/users");
            try {
                fileObj3.transferTo(new File(path, fileObj3.getOriginalFilename()));
                user.setMerchantShopImage("img/users/" + fileObj3.getOriginalFilename());
                fileObj4.transferTo(new File(path, fileObj4.getOriginalFilename()));
                user.setMerchantPermitImage("img/users/" + fileObj4.getOriginalFilename());
            } catch (IOException e) {
            }
        }
        user.setSupplierAuditStatus("0");
        boolean result = this.userService.updateById(user);
        return result;
    }
    /*通过商户审核*/
    @RequestMapping("pass")
    
    public String pass(Integer id) {
        int pass = userService.pass(id);
        return "成功";
    }

    /*不通过商户审核*/
    @RequestMapping("fail")
    
    public String fail(Integer id) {
        int pass = userService.fail(id);
        return "成功";
    }

    @RequestMapping("selectmerchant")
    
    /*查询所有商户*/
    public List<Users> selectmerchant() {
        List<Users> list = userService.selectmerchant();
        return list;
    }

    @RequestMapping("selectbymerchantId")
    
    /*根据商户ID查询商户*/
    public Users selectbymerchantId(Integer id) {
        Users users = userService.selectbymerchantId(id);
        return users;
    }

    @RequestMapping("updatemerchant")
    
    /*修改商户信息*/
    public String updatemerchant(Users users) {
        System.out.println(users);
        int updatemerchant = userService.updatemerchant(users);
        return "修改成功";
    }
    //查询商户审核不通过原因
    @RequestMapping("selectLogMerchant")
    public Loginformation selectLogMerchant(Loginformation log) {
            QueryWrapper<Loginformation> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("parent_id", log.getParentID());
            queryWrapper.eq("log_type", "商户审核不通过");
            List<Loginformation> logs = this.logInformationService.list(queryWrapper);
            if (logs.size() > 0) {
                Loginformation loginformation = logs.get(0);
                return loginformation;
            }
            return null;
        }

    //查询供应商审核不通过原因
    @RequestMapping("selectLogSupplier")
    public Loginformation selectLogSupplier(Loginformation log) {
        QueryWrapper<Loginformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", log.getParentID());
        queryWrapper.eq("log_type", "供应商审核不通过");
        List<Loginformation> logs = this.logInformationService.list(queryWrapper);
        System.out.println(logs);
        if (logs.size() > 0) {
            Loginformation loginformation = logs.get(0);
            return loginformation;
        }
        return null;
    }

    @RequestMapping("passsupplier")
    
    /*通过供应商审核*/
    public String passsupplier(Integer id) {
        int passsupplier = userService.passsupplier(id);
        return "成功";
    }

    /*不通过供应商审核*/
    @RequestMapping("failsupplier")
    
    public String failsupplier(Integer id) {
        int failsupplier = userService.failsupplier(id);
        return "不通过";
    }

    /*查询所有供应商审核信息*/
    @RequestMapping("selectallsupplier")
    
    public List<Users> selectallsupplier() {
        List<Users> users = userService.selectallsupplier();
        return users;
    }

    /*查询所有的供应商*/
    @RequestMapping("selectsupplier")
    
    public List<Users> selectsupplier() {
        List<Users> users = userService.selectsupplier();
        return users;
    }

    /*根据ID查询供应商*/
    @RequestMapping("selectsupplierbyid")
    
    public Users selectsupplierbyid(Integer id) {
        Users users = userService.selectsupplierbyid(id);
        return users;
    }

    /*修改供应商信息*/
    @RequestMapping("updatesupplier")
    
    public String updatesupplier(Users users) {
        int updatesupplier = userService.updatesupplier(users);
        return "修改成功";
    }

    /*不通过反馈信息*/
    @RequestMapping("insertloginformation")
    
    public String insertloginformation(Loginformation log) {
        System.out.println(log);
        int i = userService.insertloginformation(log);
        return "成功";
    }

    //通过ID查询用户
    @RequestMapping("selectUserByID")
    
    public Users selectUserByID(String userID) {
        Integer ID = Integer.parseInt(userID);
        Users users = userService.selectUserById(ID);

        System.out.println("aaaaaaaaaaaaaaaaaa");
        System.out.println(users);
        System.out.println("aaaaaaaaaaaaaaaaaa");

        return users;
    }
}
