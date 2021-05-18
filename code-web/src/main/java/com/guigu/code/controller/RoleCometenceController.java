package com.guigu.code.controller;

import com.guigu.code.service.RoleCometenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
@RequestMapping("rocm")
public class RoleCometenceController {
    @Autowired
    private RoleCometenceService roleCometenceService;

    @RequestMapping("add")
    @ResponseBody
    public String add(Integer roleid, String[] comid) {
        if (comid.length == 0) {
            roleCometenceService.delete(roleid);
        } else {
            roleCometenceService.delete(roleid);
            for (int i = 0; i < comid.length; i++) {
                roleCometenceService.inserts(roleid, Integer.parseInt(comid[i]));
            }
        }
        return "赋予成功";
    }
}
