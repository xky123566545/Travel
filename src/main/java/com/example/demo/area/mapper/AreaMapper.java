package com.example.demo.area.mapper;

import com.example.demo.area.entity.AreaEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description 查询省市区下拉框
 * @author xukunyuan
 * @date 2021-03-13 10:28
 */
@Mapper
public interface AreaMapper {
    /**
     * 省市区下拉框
     */
    List<AreaEntity> getArea(String pid);
}
