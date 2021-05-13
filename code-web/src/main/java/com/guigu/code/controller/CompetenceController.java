package com.guigu.code.controller;

import com.guigu.code.pojo.Competence;
import com.guigu.code.service.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin
@RequestMapping("/com")
@Controller
public class CompetenceController {
    @Autowired
    private CompetenceService competenceService;

    //根据员工id查询该员工所拥有的权限
    @RequestMapping("/list")
    @ResponseBody
    private List<Competence> selectbyemployeeid(Integer id) {
        System.out.println(id);
        List<Competence> list = competenceService.selectbyemployeeid(id);
        return list;
    }
}
