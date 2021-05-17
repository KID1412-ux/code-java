package com.guigu.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.code.pojo.ManagerRoles;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 21:10
 */
public interface ManagerRolesMapper extends BaseMapper<ManagerRoles> {

    //为员工添加新角色
    int deletebyempid(Integer id);
    int insertbyemid(Integer empid,Integer roleid);
}
