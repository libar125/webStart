package com.qing.common;

public enum ResultCodeEnum {
    //常用错误代码
    SUCCESS(200, "成功"),
    FAIL(500, "失败"),
    RECORD_NOTFOUND(400, "记录不存在"),




    EMAIL_IS_REGISTER(1000001, "邮箱已注册"),
    CODE_IS_INVALID(1000002, "验证码已过期"),
    CODE_IS_ERROR(1000003, "验证码错误"),
    PWD_IS_ERROR(1000004, "密码错误"),

    PHONE_IS_REGISTER(1000005, "手机号已注册"),
    PHONE_NOT_REGISTER(1000006, "手机号为注册"),

    FACE_AUTH_FAIL(9000005,"人脸认证失败"),



    END(1000000,"最后一个");


    private final Integer code;

    private final String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}
