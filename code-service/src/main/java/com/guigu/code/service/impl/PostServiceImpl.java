package com.guigu.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.code.mapper.PostMapper;
import com.guigu.code.pojo.Post;
import com.guigu.code.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl  extends ServiceImpl<PostMapper, Post> implements PostService{
    @Autowired
    private PostMapper postMapper;
    @Override
    public Post selectbyid(Integer id) {
        return postMapper.selectbyid(id);
    }

    @Override
    public int updatepost(Post post) {
        return postMapper.updatepost(post);
    }

    @Override
    public int insertpost(Post post) {
        return postMapper.insertpost(post);
    }

    @Override
    public List<Post> selectall() {
        return postMapper.selectall();
    }
}
