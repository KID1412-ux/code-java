package com.guigu.code.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.code.pojo.Competence;
import com.guigu.code.pojo.Post;
import com.guigu.code.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("post")
public class PostController {
    @Autowired
    private PostService postService;

    /*查询所有职务*/
    @RequestMapping("selectallpost")
    @ResponseBody
    public IPage<Post> selectallcompetence(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                                                 @RequestParam(value = "pageSize",defaultValue = "5")int pageSize,
                                                 Post post){
        QueryWrapper<Post> queryWrapper=new QueryWrapper<Post>();
        if(!StringUtils.isEmpty(post.getPostName())){
            queryWrapper.like("post_name",post.getPostName());  // where competence_name like '%val%'
        }

        IPage<Post> iPage= postService.page(new Page<Post>(pageNo,pageSize),queryWrapper);
        return iPage;
    }
    /*根据ID查询职务*/
    @RequestMapping("selectbyid")
    @ResponseBody
    public Post selectbyid(Integer id){
        Post post = postService.selectbyid(id);
        return post;
    }
    /*修改职务信息*/
    @RequestMapping("updatepost")
    @ResponseBody
    public String updatepost(Post post){
        postService.updatepost(post);
        return "修改成功";
    }
    /*添加职务信息*/
    @RequestMapping("insertpost")
    @ResponseBody
    public String insertpost(Post post){
        postService.insertpost(post);
        return "添加成功";
    }
    /*所有职务*/
    @RequestMapping("selectall")
    @ResponseBody
    public List<Post> selectall(){
        List<Post> selectall = postService.selectall();
        return selectall;
    }
}
