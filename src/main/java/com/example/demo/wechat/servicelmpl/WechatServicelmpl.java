package com.example.demo.wechat.servicelmpl;

import com.example.demo.area.entity.WeatherInfo;
import com.example.demo.wechat.entity.WechatInfo;
import com.example.demo.wechat.mapper.WecharMapper;
import com.example.demo.wechat.service.WechatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WechatServicelmpl  implements WechatService {
    @Resource
    private WecharMapper wecharMapper;
    @Override
    public void saveUser(WechatInfo wechatInfo) {
        try {
            if (wecharMapper.saveUser(wechatInfo) == 0) {
                System.out.println("新增失败！！！！");
            }
        }catch (Exception e){
            System.out.println("新增失败");
        }
    }

}
