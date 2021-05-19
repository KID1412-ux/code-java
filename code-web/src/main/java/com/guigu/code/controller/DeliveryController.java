package com.guigu.code.controller;


import com.github.pagehelper.PageInfo;
import com.guigu.code.pojo.*;
import com.guigu.code.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Delivery")
@CrossOrigin
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private DeliveryDetailService deliveryDetailService;
    @Autowired
    private MerchantOrderService merchantOrderService;
    @Autowired
    private CarService carService;
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/queryAllDelivery.action")
    public PageInfo<MyDelivery> queryAllDelivery(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                                                 @RequestParam(value = "pageSize",defaultValue = "5")int pageSize,
                                                 MyDelivery myDelivery){
        PageInfo<MyDelivery> myDeliveryPageInfo = deliveryService.queryAllDelivery(pageNo, pageSize, myDelivery);
        return myDeliveryPageInfo;
    }

    @RequestMapping("/queryDriver.action")
    public List<Driver> queryDriver(){
        List<Driver> drivers = deliveryService.queryDriver();
        return drivers;
    }

    @RequestMapping("/addDelivery.action")
    public boolean addDelivery(Delivery delivery,Integer[] ids){
        delivery.setBeginTime(new Date());
        delivery.setDeliveryStats("0");
        boolean flag=deliveryService.save(delivery);
        System.out.println(delivery.getId());
        Car car=new Car();
        car.setId(delivery.getCarId());
        car.setStats("0");
        carService.updateById(car);
        Employee employee=new Employee();
        employee.setId(delivery.getDriverId());
        employee.setStats("1");
        employeeService.updateById(employee);
        for(int i=0;i<ids.length;i++){
            DeliveryDetail deliveryDetail=new DeliveryDetail();
            deliveryDetail.setDeliveryId(delivery.getId());
            deliveryDetail.setMerchantOrderId(ids[i]);
            deliveryDetailService.save(deliveryDetail);
            MerchantOrder merchantOrder=new MerchantOrder();
            merchantOrder.setId(ids[i]);
            merchantOrder.setStats("1");
            merchantOrderService.updateById(merchantOrder);
        }
        return flag;
    }

    @RequestMapping("/deleteDelivery.action")
    public boolean deleteDelivery(Integer id){

        boolean flag= deliveryService.removeById(id);
        return true;
    }
}
