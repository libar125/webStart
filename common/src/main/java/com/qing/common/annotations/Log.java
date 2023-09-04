package com.qing.common.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

    /** 日志名称 **/
    String value() default "";

    /** 日志类型 1-PC管理端 2-APP端(待扩展) **/
    int type() default 1;
}