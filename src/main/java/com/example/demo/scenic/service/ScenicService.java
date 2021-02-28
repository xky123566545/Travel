package com.example.demo.scenic.service;

import com.example.demo.scenic.entity.ScenicInfo;
import com.example.demo.util.AppResponse;

/**
 * @Description 景点信息增删查改
 * @author xukunyuan
 * @date 2021-02-20 17:33
 */
public interface ScenicService {
    /**
     * 新增景点信息
     */
    AppResponse saveScenic(ScenicInfo scenicInfo);
    /**
     * 查询景点详情
     */
    AppResponse getScenicByScenicId(String scenicId);
    /**
     * 列表查询景点详情
     */
    AppResponse getScenic(ScenicInfo scenicInfo,Integer pageNo,Integer pageSize);
    /**
     * 修改景点信息
     */
    AppResponse updateScenic(ScenicInfo scenicInfo);
    /**
     * 删除景点信息
     */
    AppResponse deleteScenic(String scenicId,String userId);
}
