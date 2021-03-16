package com.example.demo.goodseva.service;

import com.example.demo.goodseva.entity.GoodsEvaInfo;
import com.example.demo.util.AppResponse;

/**
 * @Description商品评价增删查改
 * @author xukunyuan
 * @date 2021-03-03 20:19
 */
public interface GoodsEvaService {
    /**
     * 新增商品评价
     */
    AppResponse saveGoodsEva(GoodsEvaInfo goodsEvaInfo);
    /**
     * 查询订单详情
     */
    AppResponse getGoodsEva(String goodsId);
}
