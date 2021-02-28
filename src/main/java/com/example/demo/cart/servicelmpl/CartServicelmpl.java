package com.example.demo.cart.servicelmpl;

import com.example.demo.cart.entity.CartInfo;
import com.example.demo.cart.mapper.CartMapper;
import com.example.demo.cart.service.CartService;
import com.example.demo.util.AppResponse;
import com.example.demo.util.IDUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 购物车信息增删查改
 * @author xukunyuan
 * @date 2021-02-24 15:38
 */
@Service
public class CartServicelmpl implements CartService {
    @Resource
    private CartMapper cartMapper;
    /**
     * 新增购物车信息
     * @param cartInfo
     * @return
     */
    @Override
    public AppResponse saveCart(CartInfo cartInfo) {

        cartInfo.setCartId("cart" + IDUtil.getRandomId());

        //查询商品是否存在，存在则将数量叠加
        if (cartMapper.countGoodsId(cartInfo.getGoodsId(),cartInfo.getUserName()) != 0){
            String cnt = cartInfo.getGoodsCnt();
            int goodsCnt = Integer.parseInt(cnt);
            //叠加商品数量
            if(cartMapper.addGoodsCnt(cartInfo.getGoodsId(),goodsCnt,cartInfo.getUserName()) == 0){
                return AppResponse.bizError("叠加购物车商品数量失败");
            }
            //计算商品总价格
            if (cartMapper.countGoodsAllPrice(cartInfo.getGoodsId(),cartInfo.getUserName()) == 0){
                return AppResponse.bizError("计算总价失败，请重试");
            }
            return AppResponse.success("新增成功");
        }
        if(cartMapper.saveCart(cartInfo) == 0){
            return AppResponse.bizError("新增失败，请重试");
        }
        //计算商品总价格
        if (cartMapper.countGoodsAllPrice(cartInfo.getGoodsId(),cartInfo.getUserName()) == 0){
            return AppResponse.bizError("计算总价失败，请重试");
        }
        return AppResponse.success("新增成功");
    }

    /**
     * 列表查询购物车信息
     * @param cartInfo
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public AppResponse listCart(CartInfo cartInfo, Integer pageNo, Integer pageSize) {
        Map<String,Object> param = new HashMap<>();
        param.put("cartInfo",cartInfo);
        Page<CartInfo> page = PageHelper.startPage(pageNo,pageSize).doSelectPage(() ->{
            cartMapper.listCart(param);
        });
        return AppResponse.success("查询成功",page);
    }

    /**
     * 修改购物车商品数量
     * @param cartInfo
     * @return
     */
    @Override
    public AppResponse updateCart(CartInfo cartInfo) {
        if (cartMapper.updateCart(cartInfo) == 0){
            return AppResponse.bizError("修改购物车数量失败,请重试");
        }
        if(cartMapper.countGoodsAllPrice(cartInfo.getGoodsId(),cartInfo.getUserName()) == 0){
            return AppResponse.bizError("计算总价失败");
        }
        return AppResponse.success("修改成功");
    }

    /**
     * 删除购物车信息
     * @param goodsId
     * @param userName
     * @return
     */
    @Override
    public AppResponse deleteCart(String goodsId, String userName) {
        List<String> list = Arrays.asList(goodsId.split(","));
        if (cartMapper.deleteCart(list,userName) == 0){
            return AppResponse.bizError("删除失败，请重试");
        }
        return AppResponse.success("删除成功");
    }
}
