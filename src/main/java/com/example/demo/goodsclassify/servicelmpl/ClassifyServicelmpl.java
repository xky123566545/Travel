package com.example.demo.goodsclassify.servicelmpl;

import com.example.demo.goodsclassify.entity.ClassifyInfo;
import com.example.demo.goodsclassify.mapper.ClassifyMapper;
import com.example.demo.goodsclassify.service.ClassifyService;
import com.example.demo.util.AppResponse;
import com.example.demo.util.IDUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 商品分类增删查改
 * @author xukunyuan
 * @date 2021-02-20 14:15
 */
@Service
public class ClassifyServicelmpl implements ClassifyService {
    @Resource
    private ClassifyMapper classifyMapper;

    /**
    * @Description: 新增商品分类
    * @Param:  classifyInfo
    * @return:
    * @Author: xukunyuan
    * @Date: 2021/2/20
    */
    @Override
    public AppResponse saveClassify(ClassifyInfo classifyInfo) {
        //生成分类编号
        classifyInfo.setClassifyId(IDUtil.getRandomId());
        if(classifyMapper.saveClassify(classifyInfo) == 0){
            return AppResponse.bizError("新增失败，请重试");
        }
        return AppResponse.success("新增成功");
    }

    /**
     * 查询分类详情
     * @param classifyId
     * @return
     */
    @Override
    public AppResponse getClassifyByClassifyId(String classifyId) {
        ClassifyInfo classifyInfo = classifyMapper.getClassifyByClassifyId(classifyId);
        if(classifyInfo == null){
            return AppResponse.bizError("查询失败，请重试");
        }
        return AppResponse.success("查询成功",classifyInfo);
    }

    /**
     * 查询分类列表
     * @param classifyInfo
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public AppResponse getClassify(ClassifyInfo classifyInfo, Integer pageNo, Integer pageSize) {
        Map<String,Object> params = new HashMap<>();
        params.put("classifyInfo",classifyInfo);
        Page<ClassifyInfo> page = PageHelper.startPage(pageNo,pageSize).doSelectPage(() -> {
            classifyMapper.getClassify(params);
        });
        return AppResponse.success("查询成功",page);
    }

    /**
     * 修改分类信息
     * @param classifyInfo
     * @return
     */
    @Override
    public AppResponse updateClassify(ClassifyInfo classifyInfo) {
        if (classifyMapper.updateClassify(classifyInfo) == 0){
            return AppResponse.bizError("修改失败，请重试");
        }
        return AppResponse.success("修改成功");
    }

    /**
     * 删除分类信息
     * @param classifyId
     * @param userId
     * @return
     */
    @Override
    public AppResponse deleteClassify(String classifyId, String userId) {
        List<String> list = Arrays.asList(classifyId.split(","));
        if (classifyMapper.deleteClassify(list,userId) == 0){
            return AppResponse.bizError("删除失败，请重试");
        }
        return AppResponse.success("删除成功");
    }
}
