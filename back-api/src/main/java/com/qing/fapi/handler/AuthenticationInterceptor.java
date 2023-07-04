package com.qing.fapi.handler;

import com.qing.common.annotations.auth.UserLoginToken;
import com.qing.common.annotations.auth.SkipToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 用户权限拦截器
 *
 * @author libarwanderingmaster
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
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

//        //验证用户登录状态
//        if (!loginUtils.checkUserlogin(token)) {
//            throw new UserNotLoginException("用户未登录，请先登录");
//        }
//        //注意：此处trim是为了将byte[]转为string，从redis中读取的string会变成byte[]
//        String memberId = getValueOperations().get(token).trim();
//        MemberEntity memberEntity = StrUtil.isBlank(memberId) ? null : memberService.getById(memberId);
//        if (memberEntity == null) {
//            throw new UserNotFindException("用户不存在，请重新登录");
//        }
//
//        //用户信息写入缓存
//        String uuid = IdUtil.simpleUUID();
//        request.setAttribute(authUtils.UUIDKEY, uuid);
//        getValueOperations().set(uuid, JSONObject.toJSONString(memberEntity), authUtils.KEEP_SECOND);

        return true;
    }

    private ValueOperations<String, String> getValueOperations() {
        return stringRedisTemplate.opsForValue();
    }
}
