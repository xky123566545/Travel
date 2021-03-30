package com.example.demo.order.servicelmpl;

import com.example.demo.cart.mapper.CartMapper;
import com.example.demo.order.entity.OrderDetail;
import com.example.demo.order.entity.OrderInfo;
import com.example.demo.order.mapper.OrderMapper;
import com.example.demo.order.service.OrderService;
import com.example.demo.util.AppResponse;
import com.example.demo.util.IDUtil;
import com.example.demo.util.PagedData;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Description 订单信息增删查改
 * @author xukunyuan
 * @date 2021-02-25 15:45
 */
@Service
public class OrderServicelmpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private CartMapper cartMapper;
    /**
     * 新增订单信息
     * @param orderInfo
     * @return
     */
    @Override
    public AppResponse saveOrder(OrderInfo orderInfo) throws InterruptedException {
        //生成订单编号
        orderInfo.setOrderId("order" + IDUtil.getRandomId());
        List<String> goodsId = Arrays.asList(orderInfo.getGoodsId().split(","));
        List<String> goodsPrice = Arrays.asList(orderInfo.getGoodsPrice().split(","));
        List<String> goodsCnt  = Arrays.asList(orderInfo.getGoodsCnt().split(","));
        List<String> goodsName = Arrays.asList(orderInfo.getGoodsName().split(","));
        List<String> imgPath = Arrays.asList(orderInfo.getImgPath().split(","));
        List<String> goodsDetailId = new ArrayList<>();
        //存储int类型的商品数量
        List<Integer> goodsCntInt = new ArrayList<>();
        int allCnt = 0;
        int orderPrice = 0;
        for (int i = 0;i < goodsCnt.size();i++){
            Thread.sleep(1);
            goodsDetailId.add("orderD" + IDUtil.getRandomId());
            int cnt = Integer.parseInt(goodsCnt.get(i));
            goodsCntInt.add(cnt);
            int price = Integer.parseInt(goodsPrice.get(i));
            allCnt = allCnt + cnt;
            orderPrice = orderPrice + cnt * price;
        }
        orderInfo.setAllCnt(allCnt+"");
        orderInfo.setOrderPrice(orderPrice+"");

        List<OrderDetail> orderDetails = new ArrayList<>();
        for (int i = 0;i < goodsDetailId.size();i++){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderDetailId(goodsDetailId.get(i));
            orderDetail.setOrderId(orderInfo.getOrderId());
            orderDetail.setGoodsId1(goodsId.get(i));
            orderDetail.setGoodsCnt1(goodsCnt.get(i));
            orderDetail.setGoodsPrice1(goodsPrice.get(i));
            orderDetail.setCreateUser(orderInfo.getCreateUser());
            orderDetail.setGoodsName1(goodsName.get(i));
            orderDetail.setImgPath(imgPath.get(i));
            orderDetails.add(orderDetail);
        }

        //新增订单信息
        if (orderMapper.saveOrder(orderInfo) == 0){
            return AppResponse.bizError("新增订单失败，请重试");
        }
        //新增订单明细信息
        if (orderMapper.saveOrderDetail(orderDetails) == 0){
            return AppResponse.bizError("新增订单明细失败");
        }
        //计算订单明细总价格
        if (orderMapper.countGoodsAllPrice(goodsDetailId) == 0){
            return AppResponse.bizError("计算订单明细总价格失败");
        }
        //删除购物车信息
        if(orderInfo.getCartId() != null &&orderInfo.getCartId() != "") {
            //删除购物车信息
            cartMapper.deleteCart(goodsId, orderInfo.getUserId());
        }
        //减少对应商品的库存量
        for (int i = 0;i < goodsCntInt.size();i++){
            //若该商品属于景点
            if (goodsId.get(i).substring(0,2).equals("JD")){
                //减少景点库存量
                if (orderMapper.updateScenicStock(goodsId.get(i),goodsCntInt.get(i)) == 0){
                    return AppResponse.bizError("修改景点库存量失败");
                }
            }
            else {
                if(orderMapper.updateHotelStock(goodsId.get(i),goodsCntInt.get(i)) == 0){
                    return AppResponse.bizError("修改酒店库存量失败");
                }
            }
        }
        return AppResponse.success("新增成功");
    }

    /**
     * 列表查询订单信息
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public AppResponse listOrder(OrderInfo orderInfo,Integer pageNo, Integer pageSize) {
        Page<OrderInfo> page = PageHelper.startPage(pageNo,pageSize).doSelectPage(() ->{
            orderMapper.listOrder(orderInfo);
        });
        return AppResponse.success("查询成功", PagedData.getInstance(page));
    }

    /**
     * 修改订单状态
     * @param orderInfo
     * @return
     */
    @Override
    public AppResponse updateOrderState(OrderInfo orderInfo) {
        //当订单状态为1，2，3时，直接修改
        if (orderInfo.getOrderState().equals("1") || orderInfo.getOrderState().equals("2") || orderInfo.getOrderState().equals("3") || orderInfo.getOrderState().equals("5")){
            if (orderMapper.updateOrderState(orderInfo) == 0){
                return AppResponse.bizError("修改订单状态失败");
            }
        }
        //当订单状态为4,6时，修改订单状态的同时增加商品库存量
        else{
            if (orderMapper.updateOrderState(orderInfo) == 0){
                return AppResponse.bizError("修改订单状态失败");
            }
            List<String> goodsId = Arrays.asList(orderInfo.getGoodsId().split(","));
            List<String> goodsCnt = Arrays.asList(orderInfo.getGoodsCnt().split(","));
            for (int i = 0;i < goodsId.size();i++) {
                //订单数量
                String cntS = goodsCnt.get(i);
                int cnt = Integer.parseInt(cntS);
                //当该商品属于景点时
                if (goodsId.get(i).substring(0, 2).equals("JD")) {

                    if (orderMapper.addScenicStock(goodsId.get(i), cnt) == 0) {
                        return AppResponse.bizError("增加景点库存量失败");
                    }
                }
                //属于酒店
                else {
                    if (orderMapper.addHotelStock(goodsId.get(i), cnt) == 0) {
                        return AppResponse.bizError("增加酒店库存量失败");
                    }
                }
            }
        }
        return AppResponse.success("修改成功");
    }
}
