package com.qing.common.constant;

public class WebConstant {
    /**
     * 无需登录的接口地址集合
     */
    public static final String[] NO_LOGIN_PATH_ARR = {
            /* 主入口 */
            "/",

            /* 静态资源 */
            "/favicon.ico",
            "/doc.html",
            "/webjars/**",
            "/swagger-resources/**",
            "/v2/api-docs",
            "/v2/api-docs-ext",
            "/configuration/ui",
            "/configuration/security",
            "/ureport/**",
            "/druid/**",
            "/images/**",

            /* 认证相关 */
            "/auth/c/getPicCaptcha",
            "/auth/c/getPhoneValidCode",
            "/auth/c/doLogin",
            "/auth/c/doLoginByPhone",

            "/auth/b/getPicCaptcha",
            "/auth/b/getPhoneValidCode",
            "/auth/b/doLogin",
            "/auth/b/doLoginByPhone",

            /* 三方登录相关 */
            "/auth/third/render",
            "/auth/third/callback",

            /* 系统基础配置 */
            "/dev/config/sysBaseList",

            /* 系统字典树 */
            "/dev/dict/tree",

            /* 文件下载 */
            "/dev/file/download",

            /* 用户个人中心相关 */
            "/sys/userCenter/getPicCaptcha",
            "/sys/userCenter/findPasswordGetPhoneValidCode",
            "/sys/userCenter/findPasswordGetEmailValidCode",
            "/sys/userCenter/findPasswordByPhone",
            "/sys/userCenter/findPasswordByEmail"
    };

}
