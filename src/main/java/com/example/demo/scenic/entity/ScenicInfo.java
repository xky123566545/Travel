package com.example.demo.scenic.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@ApiModel(value = "景点对象表",description = "对应景点表")
@Data
@Table(name = "scenic_info")
public class ScenicInfo {
    @Id
    /**
     * 景点编号
     */
    private String scenicId;
    /**
     * 景点名称
     */
    private String scenicName;
    /**
     * 景点图片
     */
    private String imgPath;
    /**
     * 价格
     */
    private String scenicPrice;
    /**
     * 描述
     */
    private String scenicComment;
    /**
     * 特点
     */
    private String scenicCharacteristic;
    /**
     * 评分
     */
    private double scenicStar;
    /**
     * 负责人
     */
    private String userId;
    /**
     * 库存量
     */
    private String scenicStock;
    /**
     * 省
     */
    private String provinceId;
    /**
     * 市
     */
    private String cityId;
    /**
     * 区
     */
    private String areaId;
    /**
     * 具体地址
     */
    private String scenicAddress;
    /**
     * 分类编号
     */
    private String classifyId;
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
    /***
     * 修改时间
     */
    private Date updateTime;
    /**
     * 版本号
     */
    private String version;
}
