package com.example.demo.user.serviceImpl;

import com.example.demo.login.entity.LoginEntity;
import com.example.demo.login.mapper.LoginMapper;
import com.example.demo.user.bean.UserInfo;
import com.example.demo.user.mapper.UserMapper;
import com.example.demo.user.service.UserService;
import com.example.demo.util.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private LoginMapper loginMapper;
    /**
    * @Description: 新增用户
    * @Param:  userInfo
    * @return:  Appresponse
    * @Author: xukunyuan
    * @Date: 2021/1/8
    */
    @Override
    public AppResponse saveUser(UserInfo userInfo) {
        //通过雪花算法获取用户id
        userInfo.setUserId(IDUtil.getRandomId());
        System.out.println(userInfo.getUserId());
        //密码加密
        System.out.println("原密码 = " + userInfo.getUserPassword());
        //加密
        userInfo.setUserPassword(AESUtil.encrypt(userInfo.getUserPassword()));
        System.out.println("加密后的密码 = " + userInfo.getUserPassword());
        //输出解密后
        System.out.println("解密后的密码" + AESUtil.decrypt(userInfo.getUserPassword()));
        //设置创建人
        userInfo.setCreateUser(userInfo.getUserId());
        //判断用户是否存在
        if (userMapper.countUserName(userInfo.getUserName()) != 0){
            return AppResponse.bizError("账号已存在,请重新输入");
        }
        //新增用户
        if (userMapper.saveUser(userInfo) == 0){
            return AppResponse.bizError("新增失败,请重试");
        }
        return AppResponse.success("新增成功");
    }
    /**
     * @Description: 根据用户编号查询用户详情
     * @Param:  userId
     * @return:  Appresponse
     * @Author: xukunyuan
     * @Date: 2021/2/5
     */
    @Override
    public AppResponse getUserByUserId(String userId) {
        UserInfo userInfo = userMapper.getUserByUserId(userId);
        //密码解密
        userInfo.setUserPassword(AESUtil.decrypt(userInfo.getUserPassword()));
        if (userInfo == null){
            return AppResponse.bizError("查询失败,请重试");
        }
        return AppResponse.success("查询成功",userInfo);
    }

    @Override
    public AppResponse getUsers(UserInfo userInfo, Integer pageNo, Integer pageSize) {
        Map<String,Object> params = new HashMap<>();
        params.put("userInfo",userInfo);
        Page<UserInfo> page = PageHelper.startPage(pageNo,pageSize).doSelectPage(() -> {
            userMapper.getUsers(params);
        });
        return AppResponse.success("查询成功", PagedData.getInstance(page));
    }
    /**
    * @Description: 修改用户信息
    * @Param:  userInfo
    * @return:
    * @Author: xukunyuan
    * @Date: 2021/2/19
    */
    @Override
    public AppResponse updateUser(UserInfo userInfo) {
        //密码加密
        userInfo.setUserPassword(AESUtil.encrypt(userInfo.getUserPassword()));
        if (userMapper.updateUser(userInfo) == 0){
            return AppResponse.bizError("修改失败，请重试");
        }
        return AppResponse.success("修改成功");
    }

    //批量删除用户
    @Override
    public AppResponse deleteUser(String userId,String updateUser) {
        List<String> list =Arrays.asList(userId.split(","));
        if (userMapper.deleteUser(list,updateUser) == 0){
            return AppResponse.bizError("删除失败，请重试");
        }
        return AppResponse.success("删除成功");
    }

    /**
     * 修改密码
     * @param userName
     * @param rawPassword
     * @param newPassword
     * @return
     */
    @Override
    public AppResponse updatePassword(String userName, String rawPassword, String newPassword) {
        LoginEntity loginEntity = loginMapper.findByUserName(userName);
        String password = AESUtil.decrypt(loginEntity.getPassword());
        if (rawPassword.equals(password)){
            String newPasswordE = AESUtil.encrypt(newPassword);
            if (userMapper.updatePassword(userName,newPasswordE) == 0){
                return AppResponse.bizError("修改失败");
            }
            return AppResponse.success("修改成功");
        }
        else {
            return AppResponse.bizError("密码错误，请重新输入");
        }
    }

}
