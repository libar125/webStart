package com.qing.core.aop;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;

import com.qing.common.annotations.RequestContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author RickSun
 * @description SysLogAspect
 * @date 2021/11/16 15:54
 **/
@Component
@Aspect
@Slf4j
public class SysLogAspect {
//    private final SysLogService logService;
//
//    public SysLogAspect(SysLogService logService) {
//        this.logService = logService;
//    }

    ThreadLocal<Long> currentTime = new ThreadLocal<>();

    /**
     * 配置切入点
     */
    @Pointcut("@annotation(com.qing.common.annotations.Log)")
    public void logPointcut() {
        // 该方法无方法体,主要为了让同类中其他方法使用此切入点
    }

    /**
     * 配置环绕通知,使用在方法logPointcut()上注册的切入点
     *
     * @param joinPoint
     *            join point for advice
     */
    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result;
        currentTime.set(System.currentTimeMillis());
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert servletRequestAttributes != null;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        log.info("SysLog--请求uri = {}. 请求参数 ={}. 执行时间 = {}", request.getRequestURI(), Arrays.toString(joinPoint.getArgs()),
            System.currentTimeMillis() - currentTime.get());
        result = joinPoint.proceed();
//        SysLog log = new SysLog("1", System.currentTimeMillis() - currentTime.get());
        currentTime.remove();
//        logService.save(joinPoint, log);
        return result;
    }

    /**
     * 配置异常通知
     *
     * @param joinPoint
     *            join point for advice
     * @param e
     *            exception
     */
    @AfterThrowing(pointcut = "logPointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
//        SysLog log = new SysLog("0", System.currentTimeMillis() - currentTime.get());
        currentTime.remove();
//        log.setExceptionDetail(getStackTrace(e));
//        logService.save((ProceedingJoinPoint)joinPoint, log);
    }

    /**
     * 获取堆栈信息
     */
    public static String getStackTrace(Throwable throwable){
        StringWriter sw = new StringWriter();
        try (PrintWriter pw = new PrintWriter(sw)) {
            throwable.printStackTrace(pw);
            return sw.toString();
        }
    }

}