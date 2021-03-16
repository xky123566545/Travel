package com.example.demo.area.entity;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "area")
public class AreaEntity {
    /**
     * 编号
     */
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 父名称
     */
    private String pid;
//    /**
//     * 省市区编号
//     */
//    private String code;

}
