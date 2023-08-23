package com.qing.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qing.core.entity.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @TableName sys_log
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="sys_log")
@Data
public class Log extends BaseEntity implements Serializable {
    /**
     * 用户ip
     */
    private String ip;

    /**
     * 标题，操作方法描述
     */
    private String title;

    /**
     * 操作方法
     */
    private String method;

    /**
     * 详情
     */
    private String info;

    /**
     * 状态
     */
    private String state;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}