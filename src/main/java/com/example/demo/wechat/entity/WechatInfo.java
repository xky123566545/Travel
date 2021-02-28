package com.example.demo.wechat.entity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class WechatInfo {
    @Id
    /**
     * 编号
     */
    private String openId;
    /**
     * 名字
     */
    private String nickName;
    /**
     * 密码
     */
    private String password;
    /**
     * 图片路径
     */
    private String avatar;
    /**
     * 性别
     */
    private String sex;
}
