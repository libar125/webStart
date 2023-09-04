package com.qing.fapi.controller;

import com.qing.common.ResultMode;
import com.qing.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 *
 * @author libar
 * @date 2023/08/29
 */ 
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    /**
     * 查询所有用户列表
     * @param sto 分页查询参数
     * @return ResultMode 统一响应
     */
    @PostMapping("/list")
    public ResultMode list(String sto){
        return ResultMode.success();
    }
}
