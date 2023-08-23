package com.qing.fapi.controller;

import com.qing.core.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
public class TestController {

    private final UserServiceImpl userService;

    @GetMapping("/test")
    public void test(){
        System.out.println("这是个测试");
    }
}

