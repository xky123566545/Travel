package com.example.demo.area.controller;

import com.example.demo.area.entity.WeatherInfo;
import com.example.demo.area.service.AreaService;
import com.example.demo.util.AppResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.apache.commons.io.IOUtils;
import javax.annotation.Resource;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 查询省市区下拉框及天气预报
 * @author xukunyuan
 * @date 2021-03-13 10:28
 */
@RestController
@Api(value = "查询地点下拉框信息",description = "省市区下拉框",tags = {"查询省市区下拉框"})
@RequestMapping("/api1")
public class AreaController {
    private static Logger logger = LoggerFactory.getLogger(AreaController.class);

    @Resource
    private AreaService areaService;

    @ApiOperation(value = "根据pid查询省市区下拉框")
    @PostMapping("/getArea")
    public AppResponse getArea(String id){
        try{
            return areaService.getArea(id);
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    @ApiOperation("爬取天气预报")
    @PostMapping("/getWeather")
    public AppResponse getWeather(String City) throws IOException {
        Reader reader = null;
        BufferedReader bf = null;
        try{
            String city = URLEncoder.encode(City,"utf-8");
            Map<String,String> param= new HashMap<>();
            param.put("北京市","beijing");
            param.put("天津市","tianjing");
            param.put("石家庄市","shijiazhuang");
            param.put("唐山市","tangshan");
            param.put("秦皇岛市","qinhuangdao");
            param.put("邯郸市","handan");
            param.put("邢台市","xintai");
            param.put("保定市","baoding");
            param.put("张家口市","zhangjiakou");
            param.put("承德市","chengde");
            param.put("沧州市","cangshou");
            param.put("廊坊市","langfang");
            param.put("衡水市","hengshui");
            param.put("太原市","taiyuan");
            param.put("大同市","datong");
            param.put("阳泉市","yangquan");
            param.put("长治市","changzhi");
            param.put("晋城市","jincheng");
            param.put("朔州市","shuozhou");
            param.put("晋中市","jinzhong");
            param.put("运城市","yuncheng");
            param.put("忻州市","xinzhou");
            param.put("临汾市","linfen");
            param.put("吕梁市","lvliang");
            param.put("呼和浩特市","huhehaote");
            param.put("包头市","baotou");
            param.put("乌海市","wuhai");
            param.put("赤峰市","chifeng");
            param.put("通辽市","tongliao");
            param.put("鄂尔多斯市","eerduosi");
            param.put("呼伦贝尔市","hulunbeier");
            param.put("沈阳市","shenyang");
            param.put("大连市","dalian");
            param.put("鞍山市","anshan");
            param.put("长春市","changchun");
            param.put("吉林市","jilin");
            param.put("四平市","siping");
            param.put("哈尔滨市","haerbin");
            param.put("齐齐哈尔市","qiqihaer");
            param.put("鸡西市","jixi");
            param.put("上海市","shanghai");
            param.put("南京市","nanjing");
            param.put("无锡市","wuxi");
            param.put("徐州市","xuzhou");
            param.put("杭州市","hangzhou");
            param.put("宁波市","ningbo");
            param.put("温州市","wenzhou");
            param.put("合肥市","hefei");
            param.put("芜湖市","wuhu");
            param.put("福州市","fuzhou");
            param.put("厦门市","xiamen");
            param.put("莆田市","putian");
            param.put("南昌市","nanchang");
            param.put("景德镇市","jingdezhen");
            param.put("萍乡市","pingxiang");
            param.put("济南市","jinang");
            param.put("青岛市","qingdao");
            param.put("郑州市","zhengzhou");
            param.put("开封市","kaifeng");
            param.put("洛阳市","luoyang");
            param.put("武汉市","wuhan");
            param.put("黄石市","huangshi");
            param.put("十堰市","shiyan");
            param.put("长沙市","changsha");
            param.put("株洲市","zhuzhou");
            param.put("湘潭市","xiangtan");
            param.put("衡阳市","hengyang");
            param.put("广州市","guangzhou");
            param.put("韶关市","shaoguang");
            param.put("深圳市","shenzhen");
            param.put("珠海市","zhuhai");
            param.put("汕头市","shantou");
            param.put("佛山市","foshan");
            param.put("江门市","jiangmen");
            param.put("湛江市","zhanjiang");
            param.put("茂名市","maoming");
            param.put("肇庆市","zhaoqing");
            param.put("惠州市","huizhou");
            param.put("梅州市","meizhou");
            param.put("汕尾市","shanwei");
            param.put("河源市","heyuan");
            param.put("阳江市","yangjiang");
            param.put("清远市","qingyuan");
            param.put("东莞市","dongguan");
            param.put("中山市","zhongshan");
            param.put("潮州市","chaozhou");
            param.put("揭阳市","jieyang");
            param.put("云浮市","yunfu");

            String url = "https://www.qixiangwang.cn/" + city + ".htm";
            String[] args = new String[] {"python","C:\\Users\\Administrator\\Desktop\\毕业设计项目\\旅游网\\python\\Weather.py",url};
            Process process = Runtime.getRuntime().exec(args);
            reader = new InputStreamReader(process.getInputStream(),"gbk");
            bf = new BufferedReader(reader);
            String line = null;
            List<String> wea = new ArrayList<>();
            while((line = bf.readLine()) != null){
                wea.add(line);
            }
            if (wea.get(0).equals("0")) {
                return AppResponse.success("爬取成功");
            }
            else{
                return AppResponse.bizError("爬取失败");
            }
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
        finally {
            reader.close();
            bf.close();
        }
    }




}
