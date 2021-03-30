package com.example.demo.order.service;

import com.example.demo.order.entity.OrderInfo;
import com.example.demo.util.AppResponse;

/**
 * @Description 订单信息增删查改
 * @author xukunyuan
 * @date 2021-02-25 15:44
 */
public interface OrderService {
    /**
     * 新增订单信息
     */
    AppResponse saveOrder(OrderInfo orderInfo) throws InterruptedException;
    /**
     * 列表查询订单信息
     */
    AppResponse listOrder(OrderInfo orderInfo,Integer pageNo,Integer pageSize);
    /**
     * 修改订单状态
     */
    AppResponse updateOrderState(OrderInfo orderInfo);
}
