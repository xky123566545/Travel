package com.example.demo.cart.mapper;

import com.example.demo.cart.entity.CartInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Description 购物车信息增删查改
 * @author xukunyuan
 * @date 2021-02-24 15:55
 */
@Mapper
public interface CartMapper {
    /**
     * 根据用户名查询购物车编号
     */
    String getUserName(String userName);
    /**
     * 统计goodsId是否存在
     */
    int countGoodsId(String goodsId,String userName);
    /**
     * 修改购物车商品数量
     */
    int addGoodsCnt(String goodsId,int goodsCnt,String userName);
    /**
     * 新增购物车信息
     */
    int saveCart(CartInfo cartInfo);
    /**
     * 计算商品总价
     */
    int countGoodsAllPrice(String goodsId,String userName);
    /**
     * 列表查询购物车信息
     */
    List<CartInfo> listCart(Map<String,Object> param);
    /**
     * 修改购物车商品数量
     */
    int updateCart(CartInfo cartInfo);
    /**
     * 删除购物车信息
     */
    int deleteCart(List<String> list,String userName);

}
