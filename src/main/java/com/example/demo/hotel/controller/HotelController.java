package com.example.demo.hotel.controller;

import com.example.demo.hotel.entity.HotelDetailInfo;
import com.example.demo.hotel.entity.HotelInfo;
import com.example.demo.hotel.service.HotelService;
import com.example.demo.util.AppResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.MapsId;

/**
 * @Description 酒店信息增删查改
 * @author xukunyuan
 * @date 2021-02-22 9:23
 */
@RestController
@Api(value = "酒店信息管理",description = "酒店信息管理Api",tags = {"酒店信息增删查改"})
@RequestMapping("/api1")
public class HotelController {
    private static final Logger logger = LoggerFactory.getLogger(HotelController.class);

    @Resource
    private HotelService hotelService;

    /**
    * @Description: 新增酒店信息
    * @Param:  hotelInfo
    * @return:
    * @Author: xukunyuan
    * @Date: 2021/2/22
    */
    @ApiOperation(value = "新增酒店信息")
    @PostMapping("/saveHotel")
    public AppResponse saveHotel(@RequestBody HotelInfo hotelInfo) throws InterruptedException {
        try{
            return hotelService.saveHotel(hotelInfo);
        }catch (Exception e){
            logger.error("新增失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 新增酒店房型信息
     */
    @ApiOperation(value = "新增酒店房型信息")
    @PostMapping("/saveHotelDetails")
    public AppResponse saveHotelDetails(@RequestBody HotelDetailInfo hotelDetailInfo){
        try{
            return hotelService.saveHotelDetails(hotelDetailInfo);
        }catch (Exception e){
            logger.error("新增失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *  查询酒店信息详情
     */
    @ApiOperation(value = "查询酒店详情")
    @PostMapping("/getHotel")
    public AppResponse getHotel(String hotelId){
        try{
            return hotelService.getHotel(hotelId);
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 列表查询酒店信息
     */
    @ApiOperation("列表查询酒店信息")
    @PostMapping("/listHotel")
    public AppResponse listHotel(@RequestBody HotelInfo hotelInfo,
                                 @RequestParam(value = "currPage",required = false) Integer pageNo,
                                 @RequestParam(value = "pageSize",required = false) Integer pageSize){
        try{
            pageNo = (pageNo == null)? 1 : pageNo;
            pageSize = (pageSize == null)? 20 : pageSize;
            return hotelService.listHotel(hotelInfo,pageNo,pageSize);
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 修改酒店信息
     */
    @ApiOperation("修改酒店信息")
    @PostMapping("/updateHotel")
    public AppResponse updateHotel(@RequestBody HotelInfo hotelInfo){
        try{
            return hotelService.updateHotel(hotelInfo);
        }catch (Exception e){
            logger.error("修改失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 修改酒店房型详情
     */
    @ApiOperation("修改酒店房型详情")
    @PostMapping("/updateHotelDetail")
    public AppResponse updateHotelDetail(@RequestBody HotelDetailInfo hotelDetailInfo){
        try{
            return hotelService.updateHotelDetail(hotelDetailInfo);
        }catch (Exception e){
            logger.error("修改失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 删除酒店房型
     */
    @ApiOperation("删除酒店房型")
    @PostMapping("/deleteHotelDetail")
    public AppResponse deleteHotelDetail(String hotelTypeId,String updateUser){
        try{
            return hotelService.deleteHotelDetail(hotelTypeId,updateUser);
        }catch (Exception e){
            logger.error("删除失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 删除酒店详情
     */
    @ApiOperation("删除酒店详情")
    @PostMapping("/deleteHotel")
    public AppResponse deleteHotel(String hotelId,String updateUser){
        try{
            return hotelService.deleteHotel(hotelId,updateUser);
        }catch (Exception e){
            logger.error("删除失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
