package com.example.demo.goodseva.servicelmpl;

import com.example.demo.goodseva.entity.GoodsEvaInfo;
import com.example.demo.goodseva.mapper.GoodsEvaMapper;
import com.example.demo.goodseva.service.GoodsEvaService;
import com.example.demo.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description商品评价增删查改
 * @author xukunyuan
 * @date 2021-03-03 20:19
 */
@Service
public class GoodsEvaServicelmpl implements GoodsEvaService {

    @Resource
    private GoodsEvaMapper goodsEvaMapper;
    /**
     * 新增订单评价
     * @param goodsEvaInfo
     * @return
     */
    @Override
    public AppResponse saveGoodsEva(GoodsEvaInfo goodsEvaInfo) {
        List<String> goodsId = Arrays.asList(goodsEvaInfo.getGoodsId().split(","));
        List<String> level  = Arrays.asList(goodsEvaInfo.getLevel().split(","));
        List<String> content = Arrays.asList(goodsEvaInfo.getContent().split(","));

        List<GoodsEvaInfo> list = new ArrayList<>();
        for (int i = 0;i < goodsId.size();i++){
            GoodsEvaInfo goodsEvaInfo1 = new GoodsEvaInfo();
            String levelS = level.get(i);
            Double levelD = Double.parseDouble(levelS);
            goodsEvaInfo1.setOrderId(goodsEvaInfo.getOrderId());
            goodsEvaInfo1.setContent(content.get(i));
            goodsEvaInfo1.setGoodsId(goodsId.get(i));
            goodsEvaInfo1.setLevelDouble(levelD);
            goodsEvaInfo1.setUserName(goodsEvaInfo.getUserName());
            goodsEvaInfo1.setCreateUser(goodsEvaInfo.getCreateUser());

            //新增订单评价
            if (goodsEvaMapper.saveGoodsEva(goodsEvaInfo1) == 0){
                return AppResponse.bizError("新增商品id为" + goodsEvaInfo1.getGoodsId() + "的商品评价失败");
            }
            //修改商品评分
            //属于景点
            if (goodsId.get(i).substring(0,2).equals("JD")){
                if (goodsEvaMapper.updateScenicGoodsEva(goodsId.get(i),levelD) == 0){
                    return AppResponse.bizError("修改商品id为" + goodsEvaInfo1.getGoodsId() + "的商品评分失败");
                }
            }
            //属于酒店
            else{
                //查找订单编号
                String hotelId = goodsEvaMapper.getHotelId(goodsId.get(i));
                if (goodsEvaMapper.updateHotelGoodsEva(hotelId,levelD) == 0){
                    return AppResponse.bizError("修改商品id为" + goodsEvaInfo1.getGoodsId() + "的商品评分失败");
                }
            }
        }
        return AppResponse.success("新增成功");
    }

    /**
     * 查询订单评价详情
     * @param goodsId
     * @return
     */
    @Override
    public AppResponse getGoodsEva(String goodsId) {
        GoodsEvaInfo goodsEvaInfo = goodsEvaMapper.getGoodsEva(goodsId);
        if (goodsEvaInfo == null){
            return AppResponse.bizError("查询失败");
        }
        return AppResponse.success("查询成功",goodsEvaInfo);
    }
}
