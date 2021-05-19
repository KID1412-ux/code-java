package com.guigu.code.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.code.pojo.Car;
import com.guigu.code.pojo.Car;
import com.guigu.code.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/4/26 21:24
 */

@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping("list")
    public List<Car> list() {
        List<Car> list = this.carService.list();
        return list;
    }

    @RequestMapping("/queryAllcar.action")
    public IPage<Car> queryAllcar(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                                      @RequestParam(value = "pageSize",defaultValue = "5")int pageSize,
                                    Car car){
        QueryWrapper<Car> queryWrapper =new QueryWrapper<Car>();  // like %null%
        if(!StringUtils.isEmpty(car.getCarName())){
            queryWrapper.like("car_name",car.getCarName());  // where  name like '%val%'
        }
        if(!StringUtils.isEmpty(car.getStats())){
            queryWrapper.le("stats",car.getStats());  // where  name like '%val%'
        }

        queryWrapper.orderByAsc("id");  //根据id列进行排序

        IPage<Car>  iPage= carService.page(new Page<Car>(pageNo,pageSize),queryWrapper);
        return iPage;
    }

    @RequestMapping("/queryById.action")
//    @CrossOrigin
    public Car queryById(int id){
        Car car=carService.getById(id);
        return car;
    }

    @RequestMapping("/deleteById.action")
    public boolean deleteById(int id){
        boolean flag=carService.removeById(id);
        return flag;
    }

    //add
    @RequestMapping("/addcar.action")
    public boolean addcarinfo(Car car,
                                MultipartFile img2,
                                HttpServletRequest request){

        if(img2!=null){

            //获取当前项目发布地址/img
            String path =  request.getServletContext().getRealPath("/img");

            try {
                img2.transferTo(new File(path,img2.getOriginalFilename()));

                car.setImage("img/"+img2.getOriginalFilename());
            }catch (IOException e){
            }

        }

        boolean res = carService.save(car);
        return res;
    }

    @RequestMapping("/updatecar.action")
    public boolean updatecar(Car car,MultipartFile img2,
                               HttpServletRequest request){
        if(img2!=null){
            //获取当前项目发布地址/img
            String path =  request.getServletContext().getRealPath("/img");

            try {
                img2.transferTo(new File(path,img2.getOriginalFilename()));

                car.setImage("img/"+img2.getOriginalFilename());
            }catch (IOException e){
            }

        }
        boolean flag=carService.updateById(car);
        return flag;
    }

    @RequestMapping("/queryCar.action")
    public List<Car> queryCar(){
        QueryWrapper<Car> queryWrapper =new QueryWrapper<Car>();
        queryWrapper.eq("stats",1);
        List<Car> list = carService.list(queryWrapper);
        return list;
    }
}
