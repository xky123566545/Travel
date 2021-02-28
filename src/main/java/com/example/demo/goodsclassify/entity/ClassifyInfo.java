package com.example.demo.goodsclassify.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Description 商品分类实体类
 * @author xukunyuan
 * @date 2021-02-19 16:48
 */
@Entity
@ApiModel(value = "分类对象",description = "对应分类表")
@Data
@Table(name = "classify_info")
public class ClassifyInfo {
    @Id
    /**
     * 分类编号
     */
    private String classifyId;
    /**
     * 分类名称
     */
    private String classifyName;
    /**
     * 属于 1景点 2酒店
     */
    private String belongTo;
    /**
     * 备注
     */
    private String remarks;
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
