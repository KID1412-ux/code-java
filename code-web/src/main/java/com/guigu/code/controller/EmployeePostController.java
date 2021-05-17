package com.guigu.code.controller;

import com.guigu.code.service.EmployeePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
@RequestMapping("emppost")
public class EmployeePostController {
    @Autowired
    private EmployeePostService employeePostService;
    @RequestMapping("add")
    @ResponseBody
    public String add(Integer empid,String[] postid){
        if (postid.length==0){
            employeePostService.deletebyid(empid);
        }else {
            employeePostService.deletebyid(empid);
            for (int i=0;i<postid.length;i++){
                employeePostService.insertemppost(empid,Integer.parseInt(postid[i]));
            }
        }
        return "赋予成功";
    }
}
