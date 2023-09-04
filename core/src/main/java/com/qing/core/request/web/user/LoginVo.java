package com.qing.core.request.web.user;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginVo {

    /**
     * 手机号
     */
    private String phone;

    /**
     * 用户名
     */
    private String username;

    @NotEmpty(message = "密码不能为空")
    private String password;
}