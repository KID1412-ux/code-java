package com.guigu.code.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.code.pojo.Menus;
import com.guigu.code.pojo.Post;
import com.guigu.code.service.MenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        List<Menus> list = menusService.selectbycompetenceid(id);
        return list;
    }
    /*查询所有菜单*/
    @RequestMapping("selectall")
    @ResponseBody
    public List<Menus> selectall(){
        List<Menus> list = menusService.selectall();
        return list;
    }
    /*根据ID查询菜单*/
    @RequestMapping("selectbyid")
    @ResponseBody
    public Menus selectbyid(Integer id){
        Menus selectbyid = menusService.selectbyid(id);
        return selectbyid;
    }
    /*修改菜单信息*/
    @RequestMapping("updatemenus")
    @ResponseBody
    public String updatemenus(Menus menus){
        int updatemenus = menusService.updatemenus(menus);
        return "修改成功";
    }
    /*添加新菜单*/
    @RequestMapping("insertmenus")
    @ResponseBody
    public String insertmenus(Menus menus){
        int insertmenus = menusService.insertmenus(menus);
        return "添加成功";
    }
    /*所有菜单*/
    @RequestMapping("selectallmenus")
    @ResponseBody
    public IPage<Menus> selectallcompetence(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                                           @RequestParam(value = "pageSize",defaultValue = "5")int pageSize,
                                           Menus menus){
        QueryWrapper<Menus> queryWrapper=new QueryWrapper<Menus>();
        if(!StringUtils.isEmpty(menus.getMenuName())){
            queryWrapper.like("menu_name",menus.getMenuName());  // where competence_name like '%val%'
        }

        IPage<Menus> iPage= menusService.page(new Page<Menus>(pageNo,pageSize),queryWrapper);
        return iPage;
    }
}
