package com.guigu.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.code.pojo.CompetenceMenus;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 21:03
 */
public interface CompetenceMenusMapper extends BaseMapper<CompetenceMenus> {
    //根据权限ID删除权限菜单关联
    int deletebycomid(Integer id);
    int insert(Integer comid,Integer menusid);
}
