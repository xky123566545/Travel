package com.example.demo.area.servicelmpl;

import com.example.demo.area.entity.AreaEntity;
import com.example.demo.area.mapper.AreaMapper;
import com.example.demo.area.service.AreaService;
import com.example.demo.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 查询省市区下拉框
 * @author xukunyuan
 * @date 2021-03-13 10:28
 */
@Service
public class AreaServicelmpl implements AreaService {
    @Resource
    private AreaMapper areaMapper;

    /**
     * 查询省市区下拉框
     * @param pid
     * @return
     */
    @Override
    public AppResponse getArea(String pid) {
        List<AreaEntity> areaEntityList = areaMapper.getArea(pid);
        if (areaEntityList.size() == 0){
            return AppResponse.bizError("查询失败");
        }
        return AppResponse.success("查询成功",areaEntityList);
    }
}
