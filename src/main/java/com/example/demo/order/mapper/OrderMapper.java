package com.example.demo.order.mapper;

import com.example.demo.order.entity.OrderDetail;
import com.example.demo.order.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description 酒店信息增删查改
 * @author xukunyuan
 * @date 2021-02-25 15:46
 */
@Mapper
public interface OrderMapper {
    /**
     * 新增订单信息
     */
    int saveOrder(OrderInfo orderInfo);
    /**
     * 新增订单明细
     */
    int saveOrderDetail(List<OrderDetail> orderDetails);
    /**
     * 计算订单明细总价格
     */
    int countGoodsAllPrice(List<String> goodsDetailId);
    /**
     * 修改景点库存量
     */
    int updateScenicStock(String goodsId,Integer goodsCnt);
    /**
     * 修改酒店库存量
     */
    int updateHotelStock(String goodsId,Integer goodsCnt);
    /**
     * 列表查询订单信息
     */
    List<OrderInfo> listOrder();
    /**
     * 修改订单状态
     */
    int updateOrderState(OrderInfo orderInfo);
    /**
     * 添加景点商品库存量
     */
    int addScenicStock(String goodsId,int cnt);
    /**
     * 添加酒店库存量
     */
    int addHotelStock(String goodsId,int cnt);
}
