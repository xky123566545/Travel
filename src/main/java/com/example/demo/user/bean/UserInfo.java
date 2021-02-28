package com.example.demo.user.bean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description 用户实体类
 * @author xukunyuan
 * @date 2021-01-08 17:15
 */
@Entity
@ApiModel(value = "用户对象",description = "对应用户表")
@Getter
@Setter
@ToString
@Table(name ="user_info")
public class UserInfo {
    @Id
    /**
     * 用户编号
     */
    @ApiModelProperty(name="userId")
    private String userId;
    /**
     * 用户名
     */
    @ApiModelProperty(name="userName")
    private String userName;
    /**
     * 用户密码
     */
    @ApiModelProperty(name="userPassword")
    private String userPassword;
    /**
     * 用户角色(1为管理员，2为商家，3为用户
     */
    @ApiModelProperty(name = "userRole",example = "1")
    private Integer userRole;
    /**
     * 用户性别:1男，2女
     */
    @ApiModelProperty(name = "userSex",example = "1")
    private Integer userSex;
    /**
     * 用户电话
     */
    @ApiModelProperty(name = "userPhone")
    private String userPhone;
    /**
     * 用户邮箱
     */
    @ApiModelProperty(name = "userEmail")
    private String userEmail;
    /**
     * 用户年龄
     */
    @ApiModelProperty(name = "userAge",example = "20")
    private Integer userAge;
    /**
     * 1：无 2：景点 3：酒店 若user_role为1或者3则默认为1，若角色为2，则景点负责人为2，酒店负责人为3
     */
    @ApiModelProperty(name = "belongTo",example = "1")
    private Integer belongTo;
    /**
     * 用户头像路径
     */
    @ApiModelProperty(name = "userPicture")
    private String userPicture;
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
