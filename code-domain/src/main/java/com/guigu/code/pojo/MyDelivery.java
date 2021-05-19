package com.guigu.code.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class MyDelivery {
    private Integer id ;
    private String carName;
    private String employeeName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date beginTime;
    private Integer amount;
    private Integer deliveryStats;

    public Integer getDeliveryStats() {
        return deliveryStats;
    }

    public void setDeliveryStats(Integer deliveryStats) {
        this.deliveryStats = deliveryStats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

      void setCarName(String carName) {
        this.carName = carName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "MyDelivery{" +
                "id=" + id +
                ", carName='" + carName + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", beginTime=" + beginTime +
                ", amount=" + amount +
                '}';
    }
}
