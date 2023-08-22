//package com.qing.fapi.config;
//
//import cn.dev33.satoken.SaManager;
//import cn.dev33.satoken.dao.SaTokenDao;
//import cn.dev33.satoken.stp.StpUtil;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//public class LoginInterceptor implements HandlerInterceptor {
//
//    /***
//     * 在请求处理之前进行调用(Controller方法调用之前)
//     */
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        response.setHeader("Access-Control-Allow-Origin", (request).getHeader("Origin"));
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json");
//        // 获取当前token（这个token获取的是请求头的token，也可以用 request 获取）
//        String tokenValue = StpUtil.getTokenValue();
//        String loginId = (String) StpUtil.getLoginIdByToken(tokenValue);
//        //判断token是否过期：如果token的有效期还没到，但是activity-timeout已经过了，那么token就会失效
//        if (!StpUtil.isLogin()){
//            return false;
//        }
//
//        //判断token的创建时间是否大于2小时，如果是的话则需要刷新token
//        long time = System.currentTimeMillis() - StpUtil.getSession().getCreateTime();
//        long hour = time/1000/(60 * 60);
//        if (hour>2){
//            //这里要生成新的token的话，要先退出再重新登录
//            //根据当前登录id（和设备）退出登录
//            //StpUtil.logout(loginId,loginDevice);
//            StpUtil.logout(loginId);
//            //然后再重新登录，生成新的token
//            //StpUtil.login(loginId,loginDevice);
//            StpUtil.login(loginId);
//            String newToken = StpUtil.getTokenValue();
//            System.err.println("生成的新的token："+ newToken);
//            response.setHeader("token", newToken);
//        }
//
//        // 获取过期时间
//        long tokenTimeout = StpUtil.getTokenTimeout();
//        //token没过期，过期时间不是-1的时候，每次请求都刷新过期时间
//        if (tokenTimeout != -1){
//            SaTokenDao saTokenDao = SaManager.getSaTokenDao();
//            saTokenDao.updateSessionTimeout(StpUtil.getSession().getId(),3600);
//            saTokenDao.updateTimeout("BaseConstant.tokenCachePrefix+tokenValue",3600);
//            saTokenDao.updateTimeout("BaseConstant.cachePrefix+last-activity:"+tokenValue,3600);
//        }
//
//        return true;
//    }
//
//    /***
//     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
//     */
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("执行了拦截器的postHandle方法");
//    }
//
//    /***
//     * 整个请求结束之后被调用，也就是在DispatchServlet渲染了对应的视图之后执行（主要用于进行资源清理工作）
//     */
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("执行了拦截器的afterCompletion方法");
//    }
//}
