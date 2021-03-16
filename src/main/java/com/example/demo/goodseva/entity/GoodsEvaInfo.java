package com.example.demo.goodseva.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Description 商品评价增删查改
 * @author xukunyuan
 * @date 2021-03-03 20:05
 */
@Entity
@Data
@ApiModel(value = "订单评价信息实体类",description = "对应订单评价表")
@Table(name = "goods_eva")
public class GoodsEvaInfo {
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
     * 评分
     */
    private String level;
    /**
     * Double类型评分
     */
    private Double levelDouble;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 内容
     */
    private String content;
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
