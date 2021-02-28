package com.example.demo.cart.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Description 购物车信息增删查改
 * @author xukunyuan
 * @date 2021-02-24 15:24
 */
@Entity
@ApiModel(value = "购物车信息实体类",description = "对应购物车表")
@Data
@Table(name = "cart_info")
public class CartInfo {
    @Id
    /**
     * 购物车编号
     */
    private String cartId;
    /**
     * 商品编号
     */
    private String goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品数量
     */
    private String goodsCnt;
    /**
     * 商品单价
     */
    private String goodsPrice;
    /**
     * 商品总价
     */
    private String goodsAllPrice;
    /**
     * 图片路径
     */
    private String imgPath;
    /**
     * 商品评分
     */
    private String goodsStar;
    /**
     * 用户名
     */
    private String userName;
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
}
