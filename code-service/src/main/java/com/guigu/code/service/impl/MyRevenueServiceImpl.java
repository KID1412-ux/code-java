package com.guigu.code.service.impl;


import com.guigu.code.dto.revenue.RevenueDto;
import com.guigu.code.mapper.MyRevenueMapper;
import com.guigu.code.pojo.MyRevenue;
import com.guigu.code.service.MyRevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyRevenueServiceImpl implements MyRevenueService {

    @Autowired
    private MyRevenueMapper myRevenueMapper;

    @Override
    public List<MyRevenue> selectRevenue(Integer userId) {
        List<MyRevenue> myRevenues = myRevenueMapper.selectRevenue(userId);
        return myRevenues;
    }

    @Override
    public List<MyRevenue> selectTodayRevenue(RevenueDto dto) {
        List<MyRevenue> myRevenues = myRevenueMapper.selectTodayRevenue(dto);
        return myRevenues;
    }

    @Override
    public List<MyRevenue> selectDelivery(RevenueDto dto) {
        return myRevenueMapper.selectDelivery(dto);
    }

    @Override
    public List<MyRevenue> selectTodayTake(RevenueDto dto) {
        return myRevenueMapper.selectTodayTake(dto);
    }

    @Override
    public List<MyRevenue> selectOrder(RevenueDto dto) {
        return myRevenueMapper.selectOrder(dto);
    }

    @Override
    public List<MyRevenue> selectTake(RevenueDto dto) {
        return myRevenueMapper.selectTake(dto);
    }


}
