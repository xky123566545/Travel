package com.example.demo.user.mapper;

import com.example.demo.user.bean.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Description user Dao类
 * @author xukunyuan
 * @date 2021-01-05 15:55
 */
@Mapper
public interface UserMapper {
    /**
    * @Description: 统计用户账号数量
    * @Param:  userName
    * @return:  int
    * @Author: xukunyuan
    * @Date: 2021/1/9
    */
    int countUserName(@Param("userName") String userName);
    /**
    * @Description: 新增用户
    * @Param:  userInfo
    * @return:  int
    * @Author: xukunyuan
    * @Date: 2021/1/9
    */
    int saveUser(UserInfo userInfo);
    /**
    * @Description: 根据用户编号查询用户详情
    * @Param:  userId
    * @return:  userInfo
    * @Author: xukunyuan
    * @Date: 2021/2/5
    */
    UserInfo getUserByUserId(@Param("userId") String userId);
    /**
    * @Description: 查询用户详情列表
    * @Param:  map
    * @return:
    * @Author: xukunyuan
    * @Date: 2021/2/5
    */
    List<UserInfo> getUsers(Map<String,Object> param);
    /**
    * @Description: 修改用户信息
    * @Param:  userInfo
    * @return:  int
    * @Author: xukunyuan
    * @Date: 2021/2/19
    */
    int updateUser(UserInfo userInfo);
    /**
     * 删除用户
     */
    int deleteUser(@Param("list") List<String> list,String updateUser);
}
