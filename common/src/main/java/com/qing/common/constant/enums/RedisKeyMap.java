package com.qing.common.constant.enums;

import com.qing.common.constant.FinalStr;

/**
 * redis Key的拼接策略
 * @author RickSun && iFillDrean
 * @version 2.0
 */
public enum RedisKeyMap {


    //系统级别缓存KEY
    REPEAT_REQUEST_DETAIL("repeat_request_detail","重复提交拼接地址和session,记名不存储"),
    BASE_PARAM_LIST("base_param_list","基础参数列表"),
    BASE_PARAM_DETAIL("base_param_detail","基础参数详情"),

    //通用缓存策略
    MSG_TEMPLATE_DETAIL("msg_template_detail","短信模板详情，拼接type,msg_template_detail:1,存储实体类")
    ,SYSTEM_USER_TOKEN("pc_systemuser_token","后台用户详情，拼接token,pc_systemuser_token,记名不存储"), SYSTEM_USER_ID("pc_systemuser_id", "后台用户token，拼接id,pc_systemuser_id,记名不存储"), WX_CONFIG_DETAIL("wx_config_detail", "微信配置，拼接id:wx_config_detail:1,存储实体类"), WX_TICKET_DETAIL("wx_ticket_detail", "微信配置，拼接appid:wx_ticket_detail:jkdjk3jkdfjksj,存储map"), MALL_CATEGORY_DETAIL("mall_category_detail", "商品分类，拼接id:mall_category_detail:1,存储实体类"), CAPTCHA_CODE("captcha_code", "验证码，拼接session_id:captcha_code:xxxxx,存储验证码答案"), LOGIN_SAFE("login_safe", "登陆错误次数安全验证，拼接唯一key或IP:login_safe:xxxxx,存储实体类"), SMS_DETAIL("sms_detail", "存储发送短信内容，拼接手机号和短信类型，sms_detail_137xxxxxxxx_1")

    //业务缓存
    , ACCOUNT_DETAIL("account_detail", "用户详情，拼接id:account_detail_detail_1,存储实体类"), EMPLOYEE_CLIENT_ACCESS_TOKEN("employee_client_access_token", "阿姨端小程序微信接口请求access_token"), CUSTOMER_CLIENT_ACCESS_TOKEN("customer_client_access_token", "雇主端小程序微信接口请求access_token")

    ,WX_ACCESS_TOKEN("wx_access_token","缓存微信accessToken")

    ,OTHER_SERVICE_ORDER("other_service_order","其他阿姨的待服务订单")
    ,BIG_CONTENT_CODE("big_content_code:","大内容缓存")
    ,BIG_CONTENT_ID("big_content_ID:","大内容缓存")
    ,USER_PROTOCOL_LIST("user_protocol_list:type_code:","用户协议，隐私政策列表")
    ,STORE_AND_CHILDREN("store_and_child_store:id:","店铺及其子店铺id列表")
    ,PRODUCT_CATEGORY_LEAF_LIST("product:category:leaf-list","商品分类叶子节点列表")

    ;

    private String keyName;
    private String keyRemark;

    private RedisKeyMap(String keyName, String keyRemark) {
        this.keyName = FinalStr.project_name + ":" + FinalStr.getActive() + ":" + keyName;
        this.keyRemark = keyRemark;
    }


    public static String getKey(RedisKeyMap RedisKeyMap,Object ... param){
        StringBuffer sb = new StringBuffer(RedisKeyMap.keyName);
        for (int i = 0; i < param.length; i++) {
            sb.append(":").append(param[i]);
        }
        return sb.toString();
    }

    public String getKeyName() {
        return keyName;
    }

    public String getKeyRemark() {
        return keyRemark;
    }

    public String getKeyName(Object ... param) {
        StringBuffer sb = new StringBuffer(keyName);
        if( param == null ){
            return sb.toString();
        }
        for (int i = 0; i < param.length; i++) {
            sb.append(":").append(param[i]);
        }
        return sb.toString();
    }

    public  String getKeyName(Boolean isBatch,Object ... param){
        return getKeyName(param) + ":" +(isBatch ? "*" : "");
    }

}
