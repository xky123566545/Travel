package com.example.demo.goodseva.controller;

import com.example.demo.goodseva.entity.GoodsEvaInfo;
import com.example.demo.goodseva.service.GoodsEvaService;
import com.example.demo.util.AppResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Description 订单评价增删查
 * @author xukunyuan
 * @date 2021-03-03 20:13
 */
@RestController
@Api(value = "管理商品评价",description = "订单评价增删查",tags = ("管理商品评价"))
@RequestMapping("/api1")
public class GoodsEvaController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsEvaController.class);

    @Resource
    private GoodsEvaService goodsEvaService;

    /**
     * @Description 新增商品评价
     * @author xukunyuan
     * @date 2021-03-03 20:16
     */
    @ApiOperation(value = "新增商品评价")
    @PostMapping("/saveGoodsEva")
    public AppResponse saveGoodsEva(@RequestBody GoodsEvaInfo goodsEvaInfo){
        try{
            return goodsEvaService.saveGoodsEva(goodsEvaInfo);
        }catch (Exception e){
            logger.error("新增失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询订单评价详情
     */
    @ApiOperation(value = "查询商品评价信息")
    @PostMapping("/getGoodsEva")
    private AppResponse getGoodsEva(String goodsId){
        try{
            return goodsEvaService.getGoodsEva(goodsId);
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }


}
