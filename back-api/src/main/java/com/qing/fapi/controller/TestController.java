package com.qing.fapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/test")
    public void test(){
        System.out.println("这是个测试");
    }
}

