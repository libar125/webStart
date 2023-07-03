package com.qing.common.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 腾讯发送短信配置
 */
@Data
@Component
public class TencentSmsConfig {

    /** 腾讯云账户密钥对secretId（在访问管理中配置） */
    @Value("${tencent.sms-config.secretId}")
    private String secretId;

    /** 腾讯云账户密钥对secretKey（在访问管理中配置） */
    @Value("${tencent.sms-config.secretKey}")
    private String secretKey;

    /** 短信应用appId */
    @Value("${tencent.sms-config.appId}")
    private String appId;

    /** 短信应用appKey */
    @Value("${tencent.sms-config.appKey}")
    private String appKey;

    /** 签名 */
    @Value("${tencent.sms-config.smsSign}")
    private String smsSign;

    /** 过期时间 */
    @Value("${tencent.sms-config.expireTime}")
    private String expireTime;


    /** 登录验证码模板id */
    @Value("${tencent.sms-config.loginTempId}")
    private String loginTempId;

    /**
     * 加入好邻盟模板id
     */
    @Value("${tencent.sms-config.joinTempId}")
    private String joinTempId;

    /**
     * 注销账户验证码模板id
     */
    @Value("${tencent.sms-config.cancelTempId}")
    private String cancelTempId;

    /**
     * 修改密码验证码模板id
     */
    @Value("${tencent.sms-config.modifyPwdTempId}")
    private String modifyPwdTempId;
}

