package com.example.demo.area.controller;

import com.example.demo.area.service.AreaService;
import com.example.demo.util.AppResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 查询省市区下拉框
 * @author xukunyuan
 * @date 2021-03-13 10:28
 */
@RestController
@Api(value = "查询地点下拉框信息",description = "省市区下拉框",tags = {"查询省市区下拉框"})
@RequestMapping("/api1")
public class AreaController {
    private static Logger logger = LoggerFactory.getLogger(AreaController.class);

    @Resource
    private AreaService areaService;

    @ApiOperation(value = "根据pid查询省市区下拉框")
    @PostMapping("/getArea")
    public AppResponse getArea(String id){
        try{
            return areaService.getArea(id);
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

}
