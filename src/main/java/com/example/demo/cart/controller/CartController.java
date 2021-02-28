package com.example.demo.cart.controller;

import com.example.demo.cart.entity.CartInfo;
import com.example.demo.cart.service.CartService;
import com.example.demo.util.AppResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * @Description 购物车信息增删查改
 * @author xukunyuan
 * @date 2021-02-24 15:29
 */
@RestController
@Api(value = "购物车信息管理",description = "购物车信息管理api",tags = "购物车信息管理")
@RequestMapping("/api1")
public class CartController {
    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @Resource
    private CartService cartService;

    /**
     * 新增购物车信息
     */
    @ApiOperation("新增购物车信息")
    @PostMapping("/saveCart")
    public AppResponse saveCart(@RequestBody CartInfo cartInfo){
        try{
            return cartService.saveCart(cartInfo);
        }catch (Exception e){
            logger.error("新增失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询购物车列表
     */
    @ApiOperation("列表查询购物车信息")
    @PostMapping("/listCart")
    public AppResponse listCart(@RequestBody CartInfo cartInfo,
                                @RequestParam(value = "pageNo",required = false) Integer pageNo,
                                @RequestParam(value = "pageSize",required = false) Integer pageSize){
        try{
            pageNo = (pageNo == null)? 1 : pageNo;
            pageSize = (pageSize == null)? 20 : pageSize;
            return cartService.listCart(cartInfo,pageNo,pageSize);
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 修改购物车商品数量
     */
    @ApiOperation("修改购物车商品数量")
    @PostMapping("/updateCart")
    public AppResponse updateCart(@RequestBody CartInfo cartInfo){
        try{
            return cartService.updateCart(cartInfo);
        }catch (Exception e){
            logger.error("修改失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 删除购车信息
     */
    @ApiOperation("删除购物车信息")
    @PostMapping("/deleteCart")
    public AppResponse deleteCart(String goodsId,String userName){
        try{
            return cartService.deleteCart(goodsId,userName);
        }catch (Exception e){
            logger.error("删除失败");
            System.out.println(e.toString());
            throw e;
        }

    }
}
