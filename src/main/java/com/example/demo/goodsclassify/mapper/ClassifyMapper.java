package com.example.demo.goodsclassify.mapper;

import com.example.demo.goodsclassify.entity.ClassifyInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Description 商品分类增删查改
 * @author xukunyuan
 * @date 2021-02-20 14:24
 */
@Mapper
public interface ClassifyMapper {
    /**
    * @Description: 新增商品分类
    * @Param:  classifyInfo
    * @return:  int
    * @Author: xukunyuan
    * @Date: 2021/2/20
    */
    int saveClassify(ClassifyInfo classifyInfo);
    /**
     * 查询分类详情
     */
    ClassifyInfo getClassifyByClassifyId(String classifyId);
    /**
     * 查询分类详情
     */
    List<ClassifyInfo> getClassify(Map<String,Object> param);
    /**
     * 修改商品分类
     */
    int updateClassify(ClassifyInfo classifyInfo);
    /**
     * 删除商品分类
     */
    int deleteClassify(List<String> list,String userId );
}
