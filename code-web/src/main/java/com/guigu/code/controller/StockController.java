package com.guigu.code.controller;

import com.guigu.code.pojo.Stock;
import com.guigu.code.pojo.StockDetail;
import com.guigu.code.service.StockDetailService;
import com.guigu.code.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/5/18 18:42
 */

@RestController
@RequestMapping("stock")
@CrossOrigin
public class StockController {
    @Autowired
    private StockService stockService;

    @Autowired
    private StockDetailService stockDetailService;

    @RequestMapping("saveStock")
    public int saveStock(Stock stock) {
        StringBuffer buffer = new StringBuffer("43107000");
        String number = String.format("%04d", new Random().nextInt(9999));
        buffer.append(number);
        String stockNo = buffer.toString();
        stock.setStockNo(stockNo);
        stock.setRoadTime(new Date());
        boolean result = this.stockService.save(stock);
        return stock.getId();
    }

    @RequestMapping("saveDetail")
    public boolean saveDetail(@RequestBody List<StockDetail> details) {
        boolean result = this.stockDetailService.saveBatch(details);
        return result;
    }
}
