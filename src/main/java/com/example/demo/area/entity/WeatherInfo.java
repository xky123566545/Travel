package com.example.demo.area.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class WeatherInfo {
    @Id
    /**
     * 日期
     */
    private String date;
    /**
     * 地区
     */
    private String city;
    /**
     * 温度
     */
    private String wendu;
    /**
     * 状态
     */
    private String status;
    /**
     * 上午风向
     */
    private String fengxiangS;
    /**
     * 湿度
     */
    private String shidu;
    /**
     * 下午风向
     */
    private String fengxiangX;
}
