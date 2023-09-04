package com.qing.common.annotations;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;

/**
 * @author RickSun
 * @Description 获取Request相关信息
 **/
public interface RequestContext {

    static final String UNKNOWN = "unknown";

    /**
     * @author RickSun
     * @Description 获取HttpServletRequest
     **/
     static HttpServletRequest getRequest() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        return request;
    }

    /**
     * @author RickSun
     * @Description 获取指定请求头
     **/
     static String getHeader(String name) {
        return getRequest().getHeader(name);
    }


}
