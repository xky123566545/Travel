package com.example.demo.hotel.mapper;

import com.example.demo.hotel.entity.HotelDetailInfo;
import com.example.demo.hotel.entity.HotelInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Description 酒店信息增删查改
 * @author xukunyuan
 * @date 2021-02-22 15:35
 */
@Mapper
public interface HotelMapper {
    /**
     * 统计酒店名称数量
     */
    int countHotelName(String hotelName);
    /**
     * 新增酒店信息
     */
    int saveHotel(HotelInfo hotelInfo);
    /**
     * 新增酒店明细信息
     */
    int saveHotelDetail(List<HotelDetailInfo> hotelDetailInfo);
    /**
     * 查询酒店详情
     */
    HotelInfo getHotel(String hotelId);
    /**
     * 列表查询酒店详情
     */
    List<HotelInfo> listHotel(Map<String,Object> param);
    /**
     * 修改酒店信息
     */
    int updateHotel(HotelInfo hotelInfo);
    /**
     * 修改酒店房型详情
     */
    int updateHotelDetail(HotelDetailInfo hotelDetailInfo);
    /**
     * 删除酒店房型
     */
    int deleteHotelDetail(List<String> list,String updateUser);
    /**
     * 删除酒店信息
     */
    int deleteHotel(String hotelId,String updateUser);
    /**
     * 删除酒店房型
     */
    int deleteHotelType(String hotelId,String updateUser);
    /**
     * 新增酒店房型
     */
    int saveHotelDetails(HotelDetailInfo hotelDetailInfo);
}
