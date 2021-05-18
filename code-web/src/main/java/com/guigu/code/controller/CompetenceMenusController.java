package com.guigu.code.controller;

import com.guigu.code.service.CompetenceMenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
@RequestMapping("/cme")
public class CompetenceMenusController {
    @Autowired
    private CompetenceMenusService competenceMenusService;
    @RequestMapping("add")
    @ResponseBody
    public String add(Integer comid,String[] menuid){
        if (menuid.length==0){
            competenceMenusService.deletebycomid(comid);
        }else {
            competenceMenusService.deletebycomid(comid);
            for (int i=0;i<menuid.length;i++){
                competenceMenusService.insert(comid,Integer.parseInt(menuid[i]));
            }
        }
        return "赋予成功";
    }
}
