package com.qing.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 系统日志
 * @TableName sys_log
 */
@TableName(value ="sys_log")
@Data
public class Log implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 日志名称
     */
    private String description;

    /**
     * 来源,具体含义参考代码规定
     */
    private Integer resourceType;

    /**
     * 日志类型
     */
    private String logType;

    /**
     * 请求方法全命名
     */
    private String method;

    /**
     * 请求方式，get post put delete
     */
    private String methodType;

    /**
     * 请求参数
     */
    private String params;

    /**
     * 请求IP
     */
    private String requestIp;

    /**
     * 请求时间，单位毫秒
     */
    private Long time;

    /**
     * 请求人名称
     */
    private String username;

    /**
     * 请求地址
     */
    private String address;

    /**
     * 请求浏览器类型
     */
    private String browser;

    /**
     * 例外情况
     */
    private String exceptionDetail;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 请求唯一ID
     */
    private String requestId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}