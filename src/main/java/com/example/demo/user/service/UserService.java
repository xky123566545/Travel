package com.example.demo.user.service;

import com.example.demo.user.bean.UserBean;
import com.example.demo.user.bean.UserInfo;
import com.example.demo.util.AppResponse;

public interface UserService {
    /**
    * @Description: 新增用户
    * @Param:  UserInfo
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2021/1/8
    */
    AppResponse saveUser(UserInfo userInfo);

    /**
    * @Description: 根据用户编号查询用户详情
    * @Param:  userId
    * @return:  Appresponse
    * @Author: xukunyuan
    * @Date: 2021/2/5
    */
    AppResponse getUserByUserId(String userId);
    /**
    * @Description: 查询用户列表信息
    * @Param:
    * @return:
    * @Author: xukunyuan
    * @Date: 2021/2/5
    */
    AppResponse getUsers(UserInfo userInfo,Integer pageNo,Integer pageSize);
    /**
    * @Description: 修改用户信息
    * @Param:  userInfo
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2021/2/19
    */
    AppResponse updateUser(UserInfo userInfo);
    /**
    * @Description: 删除用户
    * @Param:  userId
    * @return:
    * @Author: xukunyuan
    * @Date: 2021/2/19
    */
    AppResponse deleteUser(String userId,String updateUser);
}
