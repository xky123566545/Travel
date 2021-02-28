package com.example.demo.wechat.mapper;

import com.example.demo.wechat.entity.WechatInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WecharMapper {
    /**
     * 新增微信用户信息
     */
    int saveUser(WechatInfo wechatInfo);
}
