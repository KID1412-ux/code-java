package com.guigu.code.service;

import com.guigu.code.dto.revenue.RevenueDto;
import com.guigu.code.pojo.MyRevenue;

import java.util.List;

public interface MyRevenueService {

    //查询商户总营收
    List<MyRevenue> selectRevenue(Integer userId);

    //查询商户今日营收
    List<MyRevenue> selectTodayRevenue(RevenueDto dto);

    //查询所有待提货数
    List<MyRevenue> selectDelivery(RevenueDto dto);

    //查询商户今日已提货数
    List<MyRevenue> selectTodayTake(RevenueDto dto);

    //查询总订单数
    List<MyRevenue> selectOrder(RevenueDto dto);

    //查询所有已提货数
    List<MyRevenue> selectTake(RevenueDto dto);

}
