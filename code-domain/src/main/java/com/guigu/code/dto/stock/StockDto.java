package com.guigu.code.dto.stock;

import lombok.Data;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/5/19 9:05
 */

@Data
public class StockDto {
    private String search_stockNo;
    private String search_StartingTime;
    private String search_endTime;
    private String search_registerStats;
    private String search_supplierId;
}
