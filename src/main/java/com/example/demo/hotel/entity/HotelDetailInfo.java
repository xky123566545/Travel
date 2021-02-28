package com.example.demo.hotel.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Description 酒店房型明细
 * @author xukunyuan
 * @date 2021-02-22 14:39
 */
@Entity
@ApiModel(value = "酒店房型明细",description = "对应酒店房型明细")
@Data
@Table(name = "hotel_detail")
public class HotelDetailInfo {
    @Id
    /**
     * 房型（大床房，豪华大床房等）
     */
    private String hotelTypeId;
    /**
     * 酒店编号
     */
    private String hotelId;
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
