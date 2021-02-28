package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.example.demo.user.mapper")
@MapperScan("com.example.demo.IPO.mapper")
@MapperScan("com.example.demo.login.mapper")
@MapperScan("com.example.demo.goodsclassify.mapper")
@MapperScan("com.example.demo.scenic.mapper")
@MapperScan("com.example.demo.hotel.mapper")
@MapperScan("com.example.demo.cart.mapper")
@MapperScan("com.example.demo.order.mapper")
@MapperScan("com.example.demo.wechat.mapper")
@EnableSwagger2
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
