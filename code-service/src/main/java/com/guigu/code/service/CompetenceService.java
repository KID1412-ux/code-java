package com.guigu.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.code.pojo.Competence;

import java.util.List;

public interface CompetenceService extends IService<Competence> {
    List<Competence> selectbyemployeeid(Integer id);
}
