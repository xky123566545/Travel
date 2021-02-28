package com.example.demo.user.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description UserBean
 * @author xukunyuan
 * @date 2021-01-05 14:20
 */
@Getter
@Setter
@ToString
public class UserBean {
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String userPassword;
    /**
     * 用户电话
     */
    private String userPhone;
    /**
     * 用户邮箱
     */
    private String userEmail;

}
