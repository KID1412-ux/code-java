package com.guigu.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.code.pojo.Post;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 21:13
 */
public interface PostMapper extends BaseMapper<Post> {
        //根据ID查询
        Post selectbyid(Integer id);
        //修该职务信息
        int updatepost(Post post);
        //添加新职务
        int insertpost(Post post);
        //查询所有职务
        List<Post> selectall();
}
