package com.qing.common.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

    /**
     * 操作模块
     * @return
     */
    String module() default "";

    /**
     * 操作类型
     * @return
     */
    String type() default "";

    /**
     * 操作说明
     * @return
     */
    String desc() default "";

}
