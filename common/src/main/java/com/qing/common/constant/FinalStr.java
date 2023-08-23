//package com.qing.common.constant;
//
//import lombok.Getter;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * @author RickSun && iFillDream
// * @version 1.0
// * @data 2020-05-08 15:58
// */
//@Component
//@Slf4j
//public class FinalStr {
//
//    /**
//     * 项目名称
//     **/
//    @Getter
//    public static String project_name;
//
//
//
//    /**
//     * 项目环境
//     **/
//    @Getter
//    private static String active;
//
//    @Getter
//    private static Integer serverPort;
//
//    @Getter
//    private static String path;
//
//    @Getter
//    private static Boolean smsIsProd;
//
//    @Getter
//    private static String dbUserName;
//
//    @Getter
//    private static String dbPassword;
//
//    @Getter
//    private static String dbUrl;
//
//
//
//
//    // 一个月存储时间
//    public static final Integer MONTH_SECOND = 60 * 60 * 24 * 30;
//
//    // 微信获取api_ticket地址
//    public static final String JSAPI_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi";
//    // 获取微信AccessToken地址
//    public static final String WX_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/stable_token";
//
//    // 允许上传的文件后缀
//    public static final List<String> okFileSuffixs = Arrays.asList(
//            ".jpg", ".jpeg", ".png", ".mp3", ".mp4", ".txt", ".json", ".gif", ".pdf", ".xls", ".xlsx", ".doc", ".docx", ".pptx", ".ppt"
//            , ".avi", ".wma", ".mov", ".ico", ".bmp", ".ftl", ".apk", ".pda", ".zip", ".rar", ".pem", ".pub", ".jar", ".war", ".html", "htm", ".sh"
//    );
//
//    // 任务名称
//    public final static String JOB_NAME = "TASK_";
//
//    // requestId
//    public final static String requestId = "requestId";
//
//    // passToken
//    public final static String passToken = "Passtoken";
//
//    // 微信支付回调
//    public static final String WX_PAY_OK = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
//    public static final String WX_PAY_FAIL = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[FAIL]]></return_msg></xml>";
//    public static final String WX_PAY_SIGN_FAIL = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[签名失败]]></return_msg></xml>";
//    public static final String WX_PAY_DATE_NULL = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[报文为空]></return_msg></xml>";
//
//    //
//    public static final String AES_ENCRYPT_KEY = "U2FsdGVkX1849jmtONpUMu1nlFKcnoHnolou1XY";
//
//    // wxconfig类
//    public static final String WX_CONFIG_KEY = "DT:WX-CONFIG-KEY:PLATFORM:";
//
//    // 素材文件
//    public static final String MATERIAL_FILE = "DT:MATERIAL-FILE:id:";
//    // 素材图片code缓存
//    public static final String MATERIAL_FILE_CODE = "DT:MATERIAL-FILE:code:";
//
//    // 严选标准
//    public static final String STRICT_SELECTION_CRITERIA = "DT:STRICT-SELECTION-CRITERIA";
//    // banner缓存
//    public static final String BANNER_LIST_PAGE = "DT:BANNER-LIST:TYPE:%s:PAGE:%s";
//    /**
//     * 雇主端-商城-首页-产品列表条数
//     */
//    public static final String INDEX_PRODUCT_SIZE = "DT:APP:EMPLOYER:INDEX:PRODUCT:LIST-SIZE";
//    // 最快上门时间字典缓存
//    public static final String FASTEST_ON_DOOR_TIME = "DT:APP:EMPLOYER:INDEX:PRODUCT:FASTEST-ON-DOOR-TIME";
//    // mall_product 缓存
//    public static final String MALL_PRODUCT = "DT:APP:EMPLOYER:MALL:PRODUCT:ID:";
//    public static final String MALL_PRODUCT_DETAIL = "DT:APP:EMPLOYER:MALL:PRODUCT-DETAIL:ID:";
//    /**
//     * 预约时间配置缓存
//     */
//    public static final String APPOINT_TIME_CONFIG = "DT:APP:EMPLOYER:MALL:APPOINT_TIME_CONFIG";
//    // 商品缓存最小时间 单位s 3分钟
//    public static final Integer MALL_PRODUCT_CACHE_MIN_TIME = 180;
//    // 商品缓存最大事件 单位s 10分钟
//    public static final Integer MALL_PRODUCT_CACHE_MAX_TIME = 600;
//
//    /**
//     * 支付订单有效时间，单位分钟
//     */
//    public static final Integer PAY_EXPIRE_MINUTES = 30;
//    public static final String TOKEN_PREFIX = "DT:token:";
//    public static final String ACCOUNT_USER = "DT:APP:Account:";
//    /**
//     * rfc3339标准时间格式，用于微信支付
//     */
//    public static final String DATE_TIME_PATTERN_RFC_3339 = "yyyy-MM-dd'T'HH:mm:ssXXX";
//    public static final String DATE_TIME_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
//    public static final String DATE_TIME_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm:ss";
//    public static final String DATE_TIME_YYYY_MM_DD = "yyyy-MM-dd";
//
//    /**
//     * 退款失败重新发起请求的key 要求一定时间之后再发，有这个key就不能发
//     */
//    public static final String ORDER_REFUND_FAIL_RESEND = "DT:APP:EMPLOYER:MALL:order-refund-resend:order-sn:";
//
//
//    @Getter
//    private static String localFileUrl;
//
//    /**
//     * 用于IP定位转换
//     */
//    public static final String REGION = "内网IP|内网IP";
//    /**
//     * win 系统
//     */
//    public static final String WIN = "win";
//
//    /**
//     * mac 系统
//     */
//    public static final String MAC = "mac";
//
//    /**
//     * 常用接口
//     */
//    public static class Url {
//        // IP归属地查询
//        public static final String IP_URL = "http://whois.pconline.com.cn/ipJson.jsp?ip=%s&json=true";
//    }
//
//    //-------Set and Get--------
//
//    @Value("${project.name}")
//    public void setProject_name(String projectName) {
//        FinalStr.project_name = projectName;
//    }
//
//    @Value(value = "${spring.profiles.active}")
//    public void setActive(String active) {
//        FinalStr.active = active;
//    }
//
//    @Value(value = "${server.servlet.context-path}")
//    public void setPath(String path) {
//        FinalStr.path = path;
//    }
//
//    @Value(value = "${oss.local}")
//    public void setLocalFileUrl(String localFileUrl) {
//        FinalStr.localFileUrl = localFileUrl;
//    }
//
//    @Value(value = "${server.port}")
//    public void setServerPort(Integer serverPort) {
//        FinalStr.serverPort = serverPort;
//    }
//
//    @Value(value = "${sms_is_prod}")
//    public void setSmsIsProd(Boolean smsIsProd) {
//        FinalStr.smsIsProd = smsIsProd;
//    }
//
//
//    @Value(value = "${db.username}")
//    public void setDbUserName(String dbUserName) {
//        FinalStr.dbUserName = dbUserName;
//    }
//
//    @Value(value = "${db.password}")
//    public void setDbPassword(String dbPassword) {
//        FinalStr.dbPassword = dbPassword;
//    }
//
//    @Value(value = "${db.url}")
//    public void setDbUrl(String dbUrl) {
//        FinalStr.dbUrl = dbUrl;
//    }
//
//    /**
//     * 密码加密Key
//     *
//     * @return
//     */
//    public static String getPwdKey() {
//        return "project_name" + "-Libar";
//    }
//
//}
