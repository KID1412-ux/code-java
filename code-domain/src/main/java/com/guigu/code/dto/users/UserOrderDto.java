package com.guigu.code.dto.users;

public class UserOrderDto {
    private Integer userId;
    private String orderNumber;
    private String orderStats;
    
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderStats() {
        return orderStats;
    }

    public void setOrderStats(String orderStats) {
        this.orderStats = orderStats;
    }
}
