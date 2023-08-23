package com.qing.fapi.controller;

import com.qing.core.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
public class TestController {

    private final UserServiceImpl userService;

}

