package com.example.demo.cart.service;

import com.example.demo.cart.entity.CartInfo;
import com.example.demo.util.AppResponse;

/**
 * @Description 购物车信息增删查改
 * @author xukunyuan
 * @date 2021-02-24 15:35
 */
public interface CartService {
    /**
     * 新增购物车信息
     */
    AppResponse saveCart(CartInfo cartInfo);
    /**
     * 列表查询购物车信息
     */
    AppResponse listCart(CartInfo cartInfo,Integer pageNo,Integer pageSize);
    /**
     * 修改购物车数量
     */
    AppResponse updateCart(CartInfo cartInfo);
    /**
     * 删除购物车信息
     */
    AppResponse deleteCart(String goodsId,String userName);
}
