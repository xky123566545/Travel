package com.example.demo.scenic.mapper;

import com.example.demo.scenic.entity.ScenicInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Description 景点信息增删查改
 * @author xukunyuan
 * @date 2021-02-20 17:38
 */
@Mapper
public interface ScenicMapper {
    /**
     * 新增景点信息
     */
    int saveScenic(ScenicInfo scenicInfo);
    /**
     * 统计景点数量
     */
    int countScenicName(String scenicName);
    /**
     * 查询景点详情
     */
    ScenicInfo getScenicByScenicId(String scenicId);
    /**
     * 列表查询景点信息
     */
    List<ScenicInfo> getScenic(Map<String,Object> param);
    /**
     * 修改景点信息
     */
    int updateScenic(ScenicInfo scenicInfo);
    /**
     * 删除景点信息
     */
    int deleteScenic(List<String> list,String userId);
}
