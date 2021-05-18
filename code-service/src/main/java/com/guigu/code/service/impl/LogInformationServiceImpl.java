package com.guigu.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.code.mapper.LogInformationMapper;
import com.guigu.code.pojo.Loginformation;
import com.guigu.code.service.LogInformationService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/5/18 8:43
 */

@Service
public class LogInformationServiceImpl extends ServiceImpl<LogInformationMapper, Loginformation> implements LogInformationService {
}
