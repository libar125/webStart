package com.qing.fapi.util;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.qing.core.request.web.user.LoginVo;
import org.springframework.stereotype.Component;

@Component
public class LoginUtil {
    public String login(LoginVo loginVo) {
        if (null == loginVo) {
            return null;
        }
        //1.读取验证码


        //2.验证验证码 不区分大小写

        //3.验证用户名密码


        // 执行登录
        StpUtil.login("userid", true);

        // 返回token
        return StpUtil.getTokenValue();
    }

}
