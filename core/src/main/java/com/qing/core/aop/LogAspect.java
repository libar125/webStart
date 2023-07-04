package com.qing.core.aop;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.qing.common.annotations.Log;
import com.qing.common.utils.IpUtil;
import com.qing.core.entity.SysLogInfoEntity;
import com.qing.core.service.SysLogErrorInfoService;
import com.qing.core.service.SysLogInfoService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Aspect
@Component
public class LogAspect {
    /**
     * 操作版本号
     * 项目启动时从命令行传入，例如：java -jar xxx.war --version=201902
     */
    @Value("${version}")
    private String version;

    /**
     * 统计请求的处理时间
     */
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Resource
    private SysLogErrorInfoService errorInfoService;

    @Resource
    private SysLogInfoService logInfoService;
    
    @Pointcut("@annotation(com.qing.common.annotations.Log)")
    public void logPointCut() {

    }

    @Before("logPointCut()")
    public void doBefore() {
        // 接收到请求，记录请求开始时间
        startTime.set(System.currentTimeMillis());
    }

    @AfterReturning(value = "logPointCut()", returning = "keys")
    public void doAfterReturning(JoinPoint joinPoint, Object keys) {
        // 获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

        // 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);


        SysLogInfoEntity logInfo = new SysLogInfoEntity();

        try {
            // 从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();

            // 获取切入点所在的方法
            Method method = signature.getMethod();

            // 获取请求的类名
            String className = joinPoint.getTarget().getClass().getName();

            // 获取操作
            Log log = method.getAnnotation(Log.class);
            if (Objects.nonNull(log)) {
                logInfo.setModule(log.module());
                logInfo.setType(log.type());
                logInfo.setMessage(log.desc());
            }

            logInfo.setMethod(className + "." + method.getName()); // 请求的方法名
            logInfo.setResParams(new Gson().toJson(converMap(request.getParameterMap()))); // 返回结果
            logInfo.setUserId(11L); // 请求用户ID
            logInfo.setUserName("1前"); // 请求用户名称
            logInfo.setIp(IpUtil.getLocalIP()); // 请求IP
            logInfo.setUri(request.getRequestURI()); // 请求URI
            logInfo.setVersion(version); // 操作版本
            logInfo.setTakeUpTime(System.currentTimeMillis() - startTime.get()); // 耗时
            logInfoService.save(logInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Map<String, String> converMap(Map<String, String[]> paramMap) {
        Map<String, String> rtnMap = new HashMap<String, String>();
        for (String key : paramMap.keySet()) {
            rtnMap.put(key, paramMap.get(key)[0]);
        }
        return rtnMap;
    }


}
