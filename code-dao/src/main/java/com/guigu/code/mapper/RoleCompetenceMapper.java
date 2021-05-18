package com.guigu.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.code.pojo.RoleCompetence;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 21:15
 */
public interface RoleCompetenceMapper extends BaseMapper<RoleCompetence> {
    //根据角色ID删除权限
    int delete(Integer id);
    int inserts(Integer roleid,Integer comid);
}
