package com.qing.fapi;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(value="com.qing.webfapi.mapper")
@SpringBootApplication
public class WebfapiApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebfapiApplication.class);
    }
}
