package com.guigu.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.code.pojo.Competence;
import com.guigu.code.pojo.Roles;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 21:15
 */
public interface RolesMapper extends BaseMapper<Roles> {
    //查询所有角色
    List<Roles> selectallroles();
    //添加新角色
    int addnewrole(Roles roles);
    //修改角色信息
    int updaterole(Roles roles);
    //根据ID查询角色
    Roles selectbyid(Integer id);
    //根据角色ID查询权限
    List<Competence> selectbycomid(Integer id);
}
