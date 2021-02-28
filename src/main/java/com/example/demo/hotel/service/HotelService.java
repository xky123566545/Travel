package com.example.demo.hotel.service;


import com.example.demo.hotel.entity.HotelDetailInfo;
import com.example.demo.hotel.entity.HotelInfo;
import com.example.demo.util.AppResponse;

/**
 * @Description 酒店信息增删查改
 * @author xukunyuan
 * @date 2021-02-22 10:09
 */
public interface HotelService {
    /**
     * 新增酒店信息
     */
    AppResponse saveHotel(HotelInfo hotelInfo) throws InterruptedException;
    /**
     * 查询酒店信息
     */
    AppResponse getHotel(String hotelId);
    /**
     * 列表查询酒店信息
     */
    AppResponse listHotel(HotelInfo hotelInfo,Integer pageNo,Integer pageSize);
    /**
     * 修改酒店信息
     */
    AppResponse updateHotel(HotelInfo hotelInfo);
    /**
     * 修改酒店房型信息详情
     */
    AppResponse updateHotelDetail(HotelDetailInfo hotelDetailInfo);
    /**
     * 删除酒店房型
     */
    AppResponse deleteHotelDetail(String hotelTypeId,String updateUser);
    /**
     * 删除酒店信息
     */
    AppResponse deleteHotel(String hotelId,String updateUser);
}
