package com.guigu.code.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.code.pojo.Competence;
import com.guigu.code.pojo.Menus;
import com.guigu.code.pojo.Roles;
import com.guigu.code.service.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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
    /*查询所有权限*/
    @RequestMapping("selectallcompetence")
    @ResponseBody
    public IPage<Competence> selectallcompetence(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                                                @RequestParam(value = "pageSize",defaultValue = "100")int pageSize,
                                                Competence competence){
        QueryWrapper<Competence> queryWrapper=new QueryWrapper<Competence>();
        if(!StringUtils.isEmpty(competence.getCompetenceName())){
            queryWrapper.like("competence_name",competence.getCompetenceName());  // where competence_name like '%val%'
        }

        IPage<Competence> iPage= competenceService.page(new Page<Competence>(pageNo,pageSize),queryWrapper);
        return iPage;
    }
    /*根据权限ID查询权限*/
    @RequestMapping("selectbycomid")
    @ResponseBody
    public Competence selectbycomid(Integer id){
        Competence selectbycomid = competenceService.selectbycomid(id);
        return selectbycomid;
    }
    /*修改权限信息*/
    @RequestMapping("updatecompetence")
    @ResponseBody
    public String updatecompetence(Competence competence){
        int updatecompetence = competenceService.updatecompetence(competence);
        System.out.println(competence);
        return "修改成功";
    }
    /*添加新权限*/
    @RequestMapping("insertcompetence")
    @ResponseBody
    public String insertcompetence(Competence competence){
        int insertcompetence = competenceService.insertcompetence(competence);
        return "添加成功";
    }
    /*根据权限ID查询菜单*/
    @RequestMapping("selectmenubycomid")
    @ResponseBody
        public List<Integer> selectmenubycomid(Integer id){
        List<Integer> l=new ArrayList<>();
        List<Menus> list = competenceService.selectmenubycomid(id);
        for (Menus i:list){
            l.add(i.getId());
        }
        return l;
    }
}
