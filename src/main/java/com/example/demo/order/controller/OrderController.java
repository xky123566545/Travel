package com.example.demo.order.controller;

import com.example.demo.order.entity.OrderInfo;
import com.example.demo.order.service.OrderService;
import com.example.demo.util.AppResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @Description 订单信息增删查改
 * @author xukunyuan
 * @date 2021-02-25 15:39
 */
@RestController
@Api(value = "订单信息管理",description = "管理订单信息",tags = {"订单信息管理"})
@RequestMapping("/api1")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private OrderService orderService;

    /**
    * @Description: 新增订单信息
    * @Param:  OrderInfo
    * @return:  AppResponse
    * @Author: xukunyuan
    * @Date: 2021/2/25
    */
    @ApiOperation("新增订单信息")
    @PostMapping("/saveOrder")
    public AppResponse saveOrder(@RequestBody OrderInfo orderInfo) throws InterruptedException {
        try{
            return orderService.saveOrder(orderInfo);
        }catch (Exception e){
            logger.error("新增失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 列表查询订单信息
     */
    @ApiOperation("列表查询订单信息")
    @PostMapping("/listOrder")
    public AppResponse listOrder(@RequestBody OrderInfo orderInfo,
                                 @RequestParam(value = "pageNo",required = false) Integer pageNo,
                                 @RequestParam(value = "pageSize",required = false) Integer pageSize){
        try{
            pageNo = (pageNo == null)? 1 : pageNo;
            pageSize= (pageSize == null)? 20 : pageSize;
            return orderService.listOrder(orderInfo,pageNo,pageSize);
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改订单状态
     */
    @ApiOperation("修改订单状态")
    @PostMapping("/updateOrderState")
    public AppResponse updateOrderState(@RequestBody OrderInfo orderInfo){
        try{
            return orderService.updateOrderState(orderInfo);
        }catch (Exception e){
            logger.error("修改失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
