package com.qing.fapi.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.qing.common.ResponseModel;
import com.qing.core.request.web.user.LoginVo;
import com.qing.fapi.util.LoginUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final LoginUtil loginUtil;

    @SaIgnore
    @GetMapping("/login")
    public ResponseModel<String> login(LoginVo loginVo) {
        String token =  loginUtil.login(loginVo);
        return ResponseModel.success(token);
    }

}

