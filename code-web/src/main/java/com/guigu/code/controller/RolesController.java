package com.guigu.code.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.code.pojo.Competence;
import com.guigu.code.pojo.Employee;
import com.guigu.code.pojo.Menus;
import com.guigu.code.pojo.Roles;
import com.guigu.code.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("role")
public class RolesController {
    @Autowired
    private RolesService rolesService;
    /*查询所有角色*/
    @RequestMapping("selectallroles")
    @ResponseBody
    public List<Roles> selectallroles(){
        List<Roles> list = rolesService.selectallroles();
        return list;
    }
    /*添加新角色*/
    @RequestMapping("addnewrole")
    @ResponseBody
    public String addnewrole(Roles roles){
        int addnewrole = rolesService.addnewrole(roles);
        return "添加成功";
    }
    /*修改角色信息*/
    @RequestMapping("updaterole")
    @ResponseBody
    public String updaterole(Roles roles){
        int updaterole = rolesService.updaterole(roles);
        return "修改成功";
    }
    /*根据ID查询角色*/
    @RequestMapping("selectbyid")
    @ResponseBody
    public Roles selectbyid(Integer id){
        Roles selectbyid = rolesService.selectbyid(id);
        return selectbyid;
    }
    /*根据角色ID查询权限*/
    @RequestMapping("selectbycomid")
    @ResponseBody
    public List<Integer> selectbycomid(Integer id){
        List<Integer> l=new ArrayList<>();
        List<Competence> list = rolesService.selectbycomid(id);
        for (Competence i:list){
            l.add(i.getId());
            System.out.println(i.getId());
        }
        return l;
    }
    /*所有角色*/
    @RequestMapping("selectall")
    @ResponseBody
    public IPage<Roles> selectallcompetence(@RequestParam(value = "pageNo",defaultValue = "") int pageNo,
                                               @RequestParam(value = "pageSize",defaultValue = "0")int pageSize,
                                               Roles  roles){
        QueryWrapper<Roles> queryWrapper=new QueryWrapper<Roles>();
        if(!StringUtils.isEmpty(roles.getRoleName())){
            queryWrapper.like("role_name",roles.getRoleName());  // where competence_name like '%val%'
        }

        IPage<Roles> iPage=rolesService.page(new Page<Roles>(pageNo,pageSize),queryWrapper);
        return iPage;
    }
}
