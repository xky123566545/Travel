package com.example.demo.area.service;

import com.example.demo.util.AppResponse;

/**
 * @Description 查询省市区下拉框
 * @author xukunyuan
 * @date 2021-03-13 10:28
 */
public interface AreaService {
    AppResponse getArea(String pid);
}
