package com.guigu.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.code.mapper.PurchaseMapper;
import com.guigu.code.pojo.Purchase;
import com.guigu.code.service.PurchaseService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author KID1412
 * @Date 2021/5/17 11:54
 */

@Service
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, Purchase> implements PurchaseService {
}
