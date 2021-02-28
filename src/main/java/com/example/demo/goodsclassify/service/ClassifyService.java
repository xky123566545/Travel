package com.example.demo.goodsclassify.service;

import com.example.demo.goodsclassify.entity.ClassifyInfo;
import com.example.demo.util.AppResponse;

/**
 * @Description 分类增删查改
 * @author xukunyuan
 * @date 2021-02-20 13:52
 */
public interface ClassifyService {
    /**
     * 新增商品分类
     */
    AppResponse saveClassify(ClassifyInfo classifyInfo);
    /**
     * 查询分类详情
     */
    AppResponse getClassifyByClassifyId(String classifyId);
    /**
     * 查询分类列表
     */
    AppResponse getClassify(ClassifyInfo classifyInfo,Integer pageNo,Integer pageSize);
    /**
     * 修改分类信息
     */
    AppResponse updateClassify(ClassifyInfo classifyInfo);
    /**
     * 删除商品分类
     */
    AppResponse deleteClassify(String classifyId,String userId);
}
