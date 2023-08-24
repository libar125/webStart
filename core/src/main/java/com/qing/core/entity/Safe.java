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
 * @TableName sys_safe
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="sys_safe")
@Data
public class Safe extends BaseEntity implements Serializable {
    /**
     * 密码更改周期（90天，60天，30天，0无）
     */
    private Integer pwdCycle;

    /**
     * 密码登录限制（0：连续错3次，锁定账号15分钟。1：连续错5次，锁定账号30分钟）
     */
    private Integer pwdLoginLimit;

    /**
     * 闲置时间设置（0：无。1：空闲30分钟，系统默认用户退出）
     */
    private Integer idleTimeSetting;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}