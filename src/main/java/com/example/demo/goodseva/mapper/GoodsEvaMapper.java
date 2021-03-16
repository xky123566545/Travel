package com.example.demo.goodseva.mapper;

import com.example.demo.goodseva.entity.GoodsEvaInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description商品评价增删查改
 * @author xukunyuan
 * @date 2021-03-03 20:19
 */
@Mapper
public interface GoodsEvaMapper {
    /**
     * 新增订单评价
     */
    int saveGoodsEva(GoodsEvaInfo goodsEvaInfo);
    /**
     * 修改景点评分
     */
    int updateScenicGoodsEva(String goodsId,Double level);
    /**
     * 修改酒店评分
     */
    int updateHotelGoodsEva(String goodsId,Double level);
    /**
     * 根据酒店明细id查询酒店id
     */
    String getHotelId(String goodsId);
    /**
     * 查询订单明旭
     */
    GoodsEvaInfo getGoodsEva(String goodsId);
}
