package com.qing.api.handler;

import com.auth0.jwt.interfaces.Claim;

import com.qing.api.util.LoginUtil;
import com.qing.common.annotations.auth.SkipToken;
import com.qing.common.annotations.auth.UserLoginToken;
import com.qing.common.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 用户权限拦截器
 *
 * @author wanderingmaster
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private LoginUtil loginUtil;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        //修复vue前端跨域401问题
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-control-Allow-Origin", request.getHeader("origin"));
        if (request.getMethod().equals(RequestMethod.OPTIONS.name())) {
            response.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
            response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
            response.setStatus(HttpStatus.OK.value());
            return false;
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        //放行不需要登录的请求
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        boolean classLogin = method.getDeclaringClass().isAnnotationPresent(UserLoginToken.class);
        boolean classSkipToken = method.getDeclaringClass().isAnnotationPresent(SkipToken.class);
        boolean methodLogin = method.isAnnotationPresent(UserLoginToken.class);
        boolean methodSkipToken = method.isAnnotationPresent(SkipToken.class);
        if (classSkipToken && !methodLogin) {
            return true;
        } else if (classLogin && methodSkipToken) {
            return true;
        } else if (!classLogin && !classSkipToken && !methodLogin) {
            return true;
        }


        //验证用户登录状态
        if (!loginUtil.checkUserLogin(token)) {
            return false;
        }

        Map<String, Claim> userData = JwtUtil.verifyToken(token);
        if (userData == null) {
            return false;
        }

        Long id = userData.get("id").asLong();
        String phone = userData.get("phone").asString();

        //拦截器 拿到用户信息，放到request中
        request.setAttribute("id", id);
        request.setAttribute("phone", phone);

        return true;
    }
}
