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
 * @TableName sys_base
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="sys_base")
@Data
public class Base extends BaseEntity implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}