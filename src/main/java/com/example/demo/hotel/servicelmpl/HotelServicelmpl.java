package com.example.demo.hotel.servicelmpl;

import com.example.demo.hotel.entity.HotelDetailInfo;
import com.example.demo.hotel.entity.HotelInfo;
import com.example.demo.hotel.mapper.HotelMapper;
import com.example.demo.hotel.service.HotelService;
import com.example.demo.util.AppResponse;
import com.example.demo.util.IDUtil;
import com.example.demo.util.PagedData;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Description 酒店信息增删查改
 * @author xukunyuan
 * @date 2021-02-22 10:11
 */
@Service
public class HotelServicelmpl implements HotelService {
    @Resource
    private HotelMapper hotelMapper;

    /**
     * 新增酒店信息
     * @param hotelInfo
     * @return
     */
    @Override
    public AppResponse saveHotel(HotelInfo hotelInfo) throws InterruptedException {
        //设置酒店编号
        hotelInfo.setHotelId("HT" + IDUtil.getRandomId());
        //将酒店类型列表存储
        List<String> hotelTypeName = Arrays.asList(hotelInfo.getHotelTypeName().split(","));
        //酒店价格
        List<String> hotelTypePrice = Arrays.asList(hotelInfo.getHotelTypePrice().split(","));
        //剩余数量
        List<String> hotelTypeStock = Arrays.asList(hotelInfo.getHotelTypeStock().split(","));
        //图片路径
        List<String> imgId  = Arrays.asList(hotelInfo.getImgId().split(","));
        //生成酒店类型明细编号
        List<String> hotelTypeId = new ArrayList<>();
        //生成酒店地址
//        String address = hotelInfo.getProvinceId() + hotelInfo.getCityId() + hotelInfo.getAreaId() + hotelInfo.getHotelAddress();
//        hotelInfo.setHotelAddress(address);
        hotelInfo.setHotelStar(5);
        for (int i = 0;i < hotelTypeName.size();i++){
            Thread.sleep(1);
            String id = "HTD" + IDUtil.getRandomId();
            hotelTypeId.add(id);
        }

        List<HotelDetailInfo> hotelDetailInfos = new ArrayList<>();
        for (int i = 0;i < hotelTypeName.size();i++){
            //hotelTypeId.add("HTD" + IDUtil.getRandomId());
            HotelDetailInfo hotelDetailInfo = new HotelDetailInfo();
            hotelDetailInfo.setHotelTypeId(hotelTypeId.get(i));
            hotelDetailInfo.setHotelTypeName(hotelTypeName.get(i));
            hotelDetailInfo.setHotelTypePrice(hotelTypePrice.get(i));
            hotelDetailInfo.setHotelTypeStock(hotelTypeStock.get(i));
            hotelDetailInfo.setImgId(imgId.get(i));
            hotelDetailInfo.setCreateUser(hotelInfo.getCreateUser());
            hotelDetailInfo.setHotelId(hotelInfo.getHotelId());

            hotelDetailInfos.add(hotelDetailInfo);
        }
        //查看酒店是否存在
        if (hotelMapper.countHotelName(hotelInfo.getHotelName()) != 0){
            return AppResponse.bizError("酒店名称已存在，请重试");
        }
        //添加酒店信息进酒店表
        if (hotelMapper.saveHotel(hotelInfo) == 0){
            return AppResponse.bizError("添加酒店信息失败");
        }
        //将酒店房间类型添加到酒店明细表
        if (hotelMapper.saveHotelDetail(hotelDetailInfos) == 0){
            return AppResponse.bizError("添加酒店信息明细失败");
        }
        return AppResponse.success("添加成功");
    }

    /**
     * 查询酒店详情
     * @param hotelId
     * @return
     */
    @Override
    public AppResponse getHotel(String hotelId) {
        HotelInfo hotelInfo = hotelMapper.getHotel(hotelId);
        if(hotelInfo == null){
            return AppResponse.bizError("查询失败，请重试");
        }
        return AppResponse.success("查询成功",hotelInfo);
    }

    /**
     * 列表查询酒店详情
     * @param hotelInfo
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public AppResponse listHotel(HotelInfo hotelInfo, Integer pageNo, Integer pageSize) {
        Map<String,Object> param = new HashMap<>();
        param.put("hotelInfo",hotelInfo);
        Page<HotelInfo> page = PageHelper.startPage(pageNo,pageSize).doSelectPage(() ->{
            hotelMapper.listHotel(param);
        });
        return AppResponse.success("查询成功", PagedData.getInstance(page));
    }

    /**
     * 修改酒店信息
     * @param hotelInfo
     * @return
     */
    @Override
    public AppResponse updateHotel(HotelInfo hotelInfo) {
       if (hotelMapper.updateHotel(hotelInfo) == 0){
           return AppResponse.bizError("修改失败,请重试");
       }
       return AppResponse.success("修改成功");
    }

    /**
     * 修改酒店房型详情
     * @param hotelDetailInfo
     * @return
     */
    @Override
    public AppResponse updateHotelDetail(HotelDetailInfo hotelDetailInfo) {
        if (hotelMapper.updateHotelDetail(hotelDetailInfo) == 0){
            return AppResponse.bizError("修改失败，请重试");
        }
        return AppResponse.success("修改成功");
    }

    /**
     * 删除酒店房型
     * @param hotelTypeId
     * @param updateUser
     * @return
     */
    @Override
    public AppResponse deleteHotelDetail(String hotelTypeId, String updateUser) {
        List<String> list = Arrays.asList(hotelTypeId.split(","));
        if (hotelMapper.deleteHotelDetail(list,updateUser) == 0){
            return AppResponse.bizError("删除失败，请重试");
        }
        return AppResponse.success("删除成功");
    }

    /**
     * 删除酒店详情
     * @param hotelId
     * @param updateUser
     * @return
     */
    @Override
    public AppResponse deleteHotel(String hotelId, String updateUser) {
        //删除酒店详情
        if (hotelMapper.deleteHotel(hotelId,updateUser) == 0){
            return AppResponse.bizError("删除酒店详情失败，请重试");
        }
        if (hotelMapper.deleteHotelType(hotelId,updateUser) == 0){
            return AppResponse.bizError("删除酒店房型失败，请重试");
        }
        return AppResponse.success("删除成功");
    }

    /**
     * 新增酒店明细详情
     * @param hotelDetailInfo
     * @return
     */
    @Override
    public AppResponse saveHotelDetails(HotelDetailInfo hotelDetailInfo) {
        //生成酒店房型编号
        hotelDetailInfo.setHotelTypeId("HTD" + IDUtil.getRandomId());
        if (hotelMapper.saveHotelDetails(hotelDetailInfo) == 0){
            return AppResponse.bizError("新增酒店房型失败");
        }
        return AppResponse.success("新增成功");
    }
}
