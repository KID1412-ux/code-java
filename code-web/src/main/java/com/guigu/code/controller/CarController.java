package com.guigu.code.controller;

import com.guigu.code.pojo.Car;
import com.guigu.code.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 21:24
 */

@RestController
@RequestMapping("car")
@CrossOrigin
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping("list")
    public List<Car> list() {
        List<Car> list = this.carService.list();
        return list;
    }
}
