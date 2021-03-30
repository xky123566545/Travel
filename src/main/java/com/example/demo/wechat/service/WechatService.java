package com.example.demo.wechat.service;

import com.example.demo.area.entity.WeatherInfo;
import com.example.demo.wechat.entity.WechatInfo;

public interface WechatService {
    /**
     * 新增微信用户信息
     */
    void saveUser(WechatInfo wechatInfo);
}
