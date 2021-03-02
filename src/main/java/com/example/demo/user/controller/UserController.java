package com.example.demo.user.controller;

import com.example.demo.user.bean.UserInfo;
import com.example.demo.user.service.UserService;
import com.example.demo.util.AppResponse;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 用户信息增删查改
 * @author xukunyuan
 * @date 2021-01-08 19:07
 */
@RestController
@RequestMapping("/api1")
@Api(description = "用户信息管理api",value = "管理用户信息",tags = {"用户信息管理"})
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

   /**
   * @Description: 新增用户
   * @Param:  userInfo
   * @return:  Appresponse
   * @Author: xukunyuan
   * @Date: 2021/1/8
   */
    @ApiOperation(value = "新增用户")
    @PostMapping("/saveUser")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "userName",value = "用户名",required = true,dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "userPassword",value = "用户密码",required = true,dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "userRole",value = "用户角色 (1为管理员，2为商家，3为用户",example = "1",required = true,dataType = "int"),
            @ApiImplicitParam(paramType = "query",name = "userSex",value = "用户性别 1男2女",example = "1",required = true,dataType = "int"),
            @ApiImplicitParam(paramType = "query",name = "userPhone",value = "用户手机",required = true,dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "userEmail",value = "用户邮箱",required = true,dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "userAge",value = "用户年龄",example = "20",required = true,dataType = "int"),
            @ApiImplicitParam(paramType = "query",name = "belongTo",value = "用户属于公司还是酒店 1：无 2：景点 3：酒店 若user_role为1或者3则默认为1，若角色为2，则景点负责人为2，酒店负责人为3",example = "1",required = true,dataType = "int"),
            @ApiImplicitParam(paramType = "query",name = "userPicture",value = "图片路径",required = true,dataType = "String"),
    }
    )
    public AppResponse saveUser(UserInfo userInfo){
        try{
            return userService.saveUser(userInfo);
        }catch (Exception e){
            logger.error("用户新增失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
    * @Description: 查询用户详情
    * @Param:  userId
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2021/2/5
    */
    @ApiOperation(value = "查询用户详情")
    @PostMapping("/getUserByUserId")
    public AppResponse getUserByUserId(@RequestParam(value = "userId",required = true) String userId){
        try{
            return userService.getUserByUserId(userId);
        }catch (Exception e){
            logger.error("查询失败,请重试！");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
    * @Description: 查询用户列表信息
    * @Param:   pageNo,pageSize,userInfo
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2021/2/5
    */
    @ApiOperation(value = "查询用户信息")
    @PostMapping("/getUsers")
    public AppResponse getUsers(@RequestBody UserInfo userInfo,
            @RequestParam(value = "currPage",required = false) Integer pageNo,
            @RequestParam(value = "pageSize",required = false) Integer pageSize){
        try{
            pageNo = (pageNo == null) ? 1 : pageNo;
            pageSize = (pageSize == null) ? 20 : pageSize;
            return userService.getUsers(userInfo,pageNo,pageSize);
        }catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    @ApiOperation(value = "修改用户信息")
    @PostMapping("/updateUser")
    public AppResponse updateUser(@RequestBody UserInfo userInfo){
        try{
            return userService.updateUser(userInfo);
        }catch (Exception e){
            logger.error("修改失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    @ApiOperation(value = "删除用户")
    @PostMapping("/deleteUser")
    public AppResponse deleteUser(String userId,String updateUser){
        try{
            return userService.deleteUser(userId,updateUser);
        }catch (Exception e){
            logger.error("删除失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }

}
