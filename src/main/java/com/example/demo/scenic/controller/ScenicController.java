package com.example.demo.scenic.controller;

import com.example.demo.scenic.entity.ScenicInfo;
import com.example.demo.scenic.service.ScenicService;
import com.example.demo.util.AppResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * @Description 景点信息增删查改
 * @author xukunyuan
 * @date 2021-02-20 17:33
 */
@RestController
@Api(description = "景点管理Api", value = "景区信息管理",tags = {"景区信息管理"})
@RequestMapping("/api1")
public class ScenicController {
    private static final Logger logger = LoggerFactory.getLogger(ScenicController.class);

    @Resource
    private ScenicService scenicService;
    /**
    * @Description: 新增景点信息
    * @Param:  scenicInfo
    * @return:
    * @Author: xukunyuan
    * @Date: 2021/2/20
    */
    @ApiOperation(value = "新增景点信息")
    @PostMapping("/saveScenic")
    public AppResponse saveScenic(@RequestBody ScenicInfo scenicInfo){
        try{
            return scenicService.saveScenic(scenicInfo);
        }catch (Exception e){
            logger.error("新增失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询景点详情
     */
    @ApiOperation(value = "查询景点详情")
    @PostMapping("/getScenicByScenicId")
    public AppResponse getScenicByScenicId(String scenicId){
        try{
            return scenicService.getScenicByScenicId(scenicId);
        }catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 列表查询景点信息
     */
    @ApiOperation(value = "列表查询景点信息")
    @PostMapping("/getScenic")
    public AppResponse getScenic(@RequestBody ScenicInfo scenicInfo,
            @RequestParam(value = "pageNo",required = false) Integer pageNo,
            @RequestParam(value = "pageSize",required = false)Integer pageSize){
        try{
            pageNo = (pageNo == null)? 1 : pageNo;
            pageSize = (pageSize == null)? 20 : pageSize;
            return scenicService.getScenic(scenicInfo,pageNo,pageSize);
        }catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 修改景点信息
     */
    @ApiOperation(value = "修改景点信息")
    @PostMapping("/updateScenic")
    public AppResponse updateScenic(@RequestBody ScenicInfo scenicInfo){
        try{
            return scenicService.updateScenic(scenicInfo);
        }catch (Exception e){
            logger.error("修改失败，请重试！");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 删除景点信息
     */
    @ApiOperation(value = "删除景点信息")
    @PostMapping("/deleteScenic")
    public AppResponse deleteScenic(String scenicId,String userId){
        try{
            return scenicService.deleteScenic(scenicId,userId);
        }catch (Exception e){
            logger.error("删除失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
