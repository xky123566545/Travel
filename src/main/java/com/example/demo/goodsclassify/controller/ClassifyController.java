package com.example.demo.goodsclassify.controller;

import com.example.demo.goodsclassify.entity.ClassifyInfo;
import com.example.demo.goodsclassify.service.ClassifyService;
import com.example.demo.util.AppResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 分类增删查改
 * @author xukunyuan
 * @date 2021-02-20 13:52
 */
@RestController
@RequestMapping("/api1")
@Api(description = "商品分类信息api",value = "管理商品分类", tags = {"商品分类管理"})
public class ClassifyController {
    private static final Logger logger = LoggerFactory.getLogger(ClassifyController.class);

    @Resource
    private ClassifyService classifyService;
    /**
    * @Description: 新增商品分类
    * @Param:  classifyInfo
    * @return:
    * @Author: xukunyuan
    * @Date: 2021/2/20
    */
    @ApiOperation(value ="新增商品分类")
    @PostMapping("/saveClassify")
    public AppResponse saveClassify(@RequestBody ClassifyInfo classifyInfo){
        try{
            return classifyService.saveClassify(classifyInfo);
        }catch (Exception e){
            logger.error("新增失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }

    @ApiOperation(value = "查询分类详情")
    @PostMapping("/getClassifyByClassifyId")
    public AppResponse getClassifyByClassifyId(String classifyId){
        try{
            return classifyService.getClassifyByClassifyId(classifyId);
        }catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }

    @ApiOperation(value = "列表查询商品分类")
    @PostMapping("/getClassify")
    public AppResponse getClassify(@RequestBody ClassifyInfo classifyInfo,
                                    @RequestParam(value = "currPage",required = false) Integer pageNo,
                                   @RequestParam(value = "pageSize",required = false) Integer pageSize){
        try{
            pageNo = (pageNo == null)? 1 : pageNo;
            pageSize = (pageSize == null)? 20 : pageSize;
            return classifyService.getClassify(classifyInfo,pageNo,pageSize);
        }catch (Exception e){
            logger.error("查询失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }

    @ApiOperation(value = "修改分类信息")
    @PostMapping("/updateClassify")
    public AppResponse updateClassify(@RequestBody ClassifyInfo classifyInfo){
        try{
            return classifyService.updateClassify(classifyInfo);
        }catch (Exception e){
            logger.error("修改失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }

    @ApiOperation(value = "删除商品分类")
    @PostMapping("/deleteClassify")
    public AppResponse deleteClassify(String classifyId,String userId){
        try{
            return classifyService.deleteClassify(classifyId,userId);
        }catch (Exception e){
            logger.error("删除失败，请重试");
            System.out.println(e.toString());
            throw e;
        }
    }
}
