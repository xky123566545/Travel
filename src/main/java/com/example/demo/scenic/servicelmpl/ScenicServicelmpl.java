package com.example.demo.scenic.servicelmpl;

import com.example.demo.scenic.entity.ScenicInfo;
import com.example.demo.scenic.mapper.ScenicMapper;
import com.example.demo.scenic.service.ScenicService;
import com.example.demo.util.AppResponse;
import com.example.demo.util.IDUtil;
import com.example.demo.util.PagedData;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScenicServicelmpl implements ScenicService {
    @Resource
    private ScenicMapper scenicMapper;

    /**
     * 新增景点信息
     * @param scenicInfo
     * @return
     */
    @Override
    public AppResponse saveScenic(ScenicInfo scenicInfo) {
        //创建景点编号
        String scenicId = "JD" + IDUtil.getRandomId();
        scenicInfo.setScenicId(scenicId);
        //查看景点名称是否存在
        if(scenicMapper.countScenicName(scenicInfo.getScenicName()) != 0){
            return AppResponse.bizError("景点已存在，请重试");
        }
        if(scenicMapper.saveScenic(scenicInfo) == 0){
            return AppResponse.bizError("新增失败");
        }
        return AppResponse.success("新增成功");
    }

    /**
     * 查询景点详情
     * @param scenicId
     * @return
     */
    @Override
    public AppResponse getScenicByScenicId(String scenicId) {
        ScenicInfo scenicInfo = scenicMapper.getScenicByScenicId(scenicId);
        if(scenicInfo == null){
            return AppResponse.bizError("查询失败");
        }
        return AppResponse.success("查询成功",scenicInfo);
    }

    /**
     * 列表查询景点信息
     * @param scenicInfo
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public AppResponse getScenic(ScenicInfo scenicInfo, Integer pageNo, Integer pageSize) {
        Map<String,Object> param = new HashMap<>();
        param.put("scenicInfo",scenicInfo);
        Page<ScenicInfo> page = PageHelper.startPage(pageNo,pageSize).doSelectPage(() -> {
            scenicMapper.getScenic(param);
        });
        return AppResponse.success("查询成功", PagedData.getInstance(page));
    }

    /**
     * 修改景点详情
     * @param scenicInfo
     * @return
     */
    @Override
    public AppResponse updateScenic(ScenicInfo scenicInfo) {
        if (scenicMapper.updateScenic(scenicInfo) == 0){
            return AppResponse.bizError("修改失败，请重试");
        }
        return AppResponse.success("修改成功");
    }

    /**
     * 删除景点信息
     * @param scenicId
     * @param userId
     * @return
     */
    @Override
    public AppResponse deleteScenic(String scenicId, String userId) {
        List<String> list = Arrays.asList(scenicId.split(","));
        if (scenicMapper.deleteScenic(list,userId) == 0){
            return AppResponse.bizError("删除失败，请重试");
        }
        return AppResponse.success("删除成功");
    }


}
