package com.guigu.code.controller;

import com.guigu.code.pojo.Menus;
import com.guigu.code.service.MenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/menus")
@CrossOrigin
public class MenusController {
    @Autowired
    private MenusService menusService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Menus> selectbycompetenceid(Integer id){
        System.out.println(id);
        List<Menus> list = menusService.selectbycompetenceid(id);
        return list;
    }
}
