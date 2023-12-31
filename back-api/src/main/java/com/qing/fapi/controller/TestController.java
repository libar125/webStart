package com.qing.fapi.controller;

import com.qing.common.ResultMode;
import com.qing.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 *
 * @author libar
 * @date 2023/08/29
 */ 
@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * 这个是一个测试
     */
    @GetMapping("/test")
    public void test(){
        System.out.println("这是一个测试方法");

    }

}
