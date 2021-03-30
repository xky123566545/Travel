package com.example.demo.order.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Description 订单明细表
 * @author xukunyuan
 * @date 2021-02-24 15:11
 */
@Entity
@ApiModel(value = "订单明细表对象",description = "对应订单表")
@Data
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    /**
     * 订单明细编号
     */
    private String orderDetailId;
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 商品编号
     */
    private String goodsId1;
    /**
     * 商品名称
     */
    private String goodsName1;
    /**
     * 商品单价
     */
    private String goodsPrice1;
    /**
     * 商品数量
     */
    private String goodsCnt1;
    /**
     * 订单总价钱
     */
    private String goodsAllPrice;
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
     * 图片路径
     */
    private String imgPath;
}
