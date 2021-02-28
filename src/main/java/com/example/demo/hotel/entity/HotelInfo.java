package com.example.demo.hotel.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * @Description 酒店信息实体类
 * @author xukunyuan
 * @date 2021-02-22 9:07
 */
@Entity
@Data
@ApiModel(value = "酒店对象实体类",description = "对应酒店表")
@Table(name = "hotel_info")
public class HotelInfo {
    @Id
    /**
     * 酒店编号
     */
    private String hotelId;
    /**
     * 酒店名称
     */
    private String hotelName;
    /**
     * 图片路径
     */
    private String imgPath;
    /**
     * 酒店描述
     */
    private String hotelComment;
    /**
     * 酒店特点
     */
    private String hotelCharacteristic;
    /**
     * 酒店评分
     */
    private double hotelStar;
    /**
     * 酒店管理人
     */
    private String userId;
    /**
     * 省级编号
     */
    private String provinceId;
    /**
     * 市级编号
     */
    private String cityId;
    /**
     * 区级编号
     */
    private String areaId;
    /**
     * 酒店地址
     */
    private String hotelAddress;
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
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 版本号
     */
    private String version;
    /**
     * 酒店明细List
     */
    @Transient
    private List<HotelDetailInfo> hotelDetailInfos;
    /**
     * 房型（大床房，豪华大床房等）
     */
    private String hotelTypeId;
    /**
     * 酒店房型名称
     */
    private String hotelTypeName;
    /**
     * 酒店类型价格
     */
    private String hotelTypePrice;
    /**
     * 酒店类型剩余数量
     */
    private String hotelTypeStock;
    /**
     * 酒店类型图片路径
     */
    private String imgId;
}
