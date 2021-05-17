package com.guigu.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.code.pojo.Post;

import java.util.List;

public interface PostService extends IService<Post> {
    //根据ID查询
    Post selectbyid(Integer id);
    //修该职务信息
    int updatepost(Post post);
    //添加新职务
    int insertpost(Post post);
    //查询所有职务
    List<Post> selectall();
}
