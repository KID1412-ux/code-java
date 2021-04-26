package com.guigu.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.code.mapper.CarMapper;
import com.guigu.code.pojo.Car;
import com.guigu.code.service.CarService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 21:22
 */

@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements CarService {
}
