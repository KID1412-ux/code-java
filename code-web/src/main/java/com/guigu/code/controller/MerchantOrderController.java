package com.guigu.code.controller;

import com.guigu.code.dto.revenue.RevenueDto;
import com.guigu.code.dto.users.MerchantOrderDto;
import com.guigu.code.dto.users.UserOrderDto;
import com.guigu.code.pojo.MerchantOrder;
import com.guigu.code.pojo.MyMerchantOrder;
import com.guigu.code.pojo.MyRevenue;
import com.guigu.code.pojo.MyUserOrder;
import com.guigu.code.service.MerchantOrderService;
import com.guigu.code.service.MyRevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("merchantOrder")
public class MerchantOrderController {
    @Autowired
    private MerchantOrderService merchantOrderService;
    @Autowired
    private MyRevenueService myRevenueService;

    @RequestMapping("selectMerchantOrders")
    public List<MyMerchantOrder> selectMerchantOrders(MerchantOrderDto dto){
        return merchantOrderService.selectMerchantOrders(dto);
    }
    @RequestMapping("selectAllMerchantOrder")
    public List<MyMerchantOrder> selectAllMerchantOrder(MerchantOrderDto dto){
        return merchantOrderService.selectAllMerchantOrder(dto);
    }
    @RequestMapping("receipt")
    public boolean receipt(MerchantOrder merchantOrder){
        return merchantOrderService.updateById(merchantOrder);
    }
    @RequestMapping("selectMerchantOrderDetail")
    public List<MyMerchantOrder> selectMerchantOrderDetail(Integer merchantOrderId){
        return merchantOrderService.selectMerchantOrderDetail(merchantOrderId);
    }

    @RequestMapping("revenueSelect")
    public List<Map> revenueSelect(Integer userId){

        List<Map> list = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date time1 = calendar.getTime();
        Date time2 = calendar.getTime();
        time2.setDate(time2.getDate()+1);
        SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //第一天
        String format1 = dayFormat.format(time1);
        //第二天
        String format2 = dayFormat.format(time2);
        RevenueDto dto=new RevenueDto();
        dto.setId(userId);
        dto.setTime1(format1);
        dto.setTime2(format2);
        List<MyRevenue> myRevenues1 = myRevenueService.selectTodayRevenue(dto);
        double today=0;
        for (MyRevenue myRevenue:myRevenues1) {
            today+=myRevenue.getGoodsPrice()*myRevenue.getGoodsAmount();
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name","今日营收");
        map1.put("value",(today/10));
        list.add(map1);
        List<MyRevenue> myRevenues2 = myRevenueService.selectRevenue(userId);
        double zj=0;
        for (MyRevenue myRevenue:myRevenues2) {
            zj+=myRevenue.getGoodsPrice()*myRevenue.getGoodsAmount();
        }
        Map<String, Object> map2 = new HashMap<>();
        map2.put("name","总营收");
        map2.put("value",(zj/10));
        list.add(map2);

        System.out.println("3333333333");
        System.out.println(list);
        System.out.println("3333333333");
        return list;
    }

    @RequestMapping("MerchantCard")
    public Map<String,Object> MerchantCard(Integer userId){

        Map<String,Object> map=new HashMap<>();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date time1 = calendar.getTime();
        Date time2 = calendar.getTime();
        time2.setDate(time2.getDate()+1);
        SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //第一天
        String format1 = dayFormat.format(time1);
        //第二天
        String format2 = dayFormat.format(time2);
        RevenueDto dto = new RevenueDto();
        dto.setId(userId);
        dto.setTime1(format1);
        dto.setTime2(format2);

        //所有待提货
        List<MyRevenue> deilvery = myRevenueService.selectDelivery(dto);
        int size1 = deilvery.size();
        map.put("deilvery",size1);

        //今日已提货数
        List<MyRevenue> todayTake = myRevenueService.selectTodayTake(dto);
        int size2 = todayTake.size();
        map.put("todayTake",size2);

        //查询所有订单
        List<MyRevenue> order = myRevenueService.selectOrder(dto);
        int size3 = order.size();
        map.put("order",size3);

        //查询所有已提货数
        List<MyRevenue> take = myRevenueService.selectTake(dto);
        int size4 = take.size();
        map.put("take",size4);

        return map;
    }

}
