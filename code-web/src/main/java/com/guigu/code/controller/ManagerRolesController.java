package com.guigu.code.controller;

import com.guigu.code.service.ManagerRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@CrossOrigin
@Controller
@RequestMapping("manager")
public class ManagerRolesController {
    @Autowired
    private ManagerRolesService managerRolesService;

    @RequestMapping("add")
    @ResponseBody
    public String add(Integer empid,String[] roleid){
      if (roleid.length==0){
          managerRolesService.deletebyempid(empid);
      }else {
          managerRolesService.deletebyempid(empid);
          for (int i=0;i<roleid.length;i++){
              managerRolesService.insertbyemid(empid,Integer.parseInt(roleid[i]));
          }
      }
        return "赋予成功";
    }
}
