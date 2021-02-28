package com.example.demo.order.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * @Description 订单信息增删查改
 * @author xukunyuan
 * @date 2021-02-24 14:48
 */
@Entity
@ApiModel(value = "订单对象实体类",description = "对应订单表")
@Table(name = "order_info")
@Data
public class OrderInfo {
    @Id
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 商品编号
     */
    private String goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品价格
     */

    private String goodsPrice;
    /**
     * 商品数量
     */
    private String goodsCnt;
    /**
     * 订单总价格
     */
    private String allCnt;
    /**
     * 订单总价钱
     */
    private String orderPrice;
    /**
     * 订单状态
     */
    private String orderState;
    /**
     * 购物车编号
     */
    private String cartId;
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 作废标记
     */
    private String isDelete;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改人
     */
    private String updateUser;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 版本号
     */
    private String version;
    /**
     * 商品明细列表
     */
    @Transient
    List<OrderDetail> orderDetails;

}
