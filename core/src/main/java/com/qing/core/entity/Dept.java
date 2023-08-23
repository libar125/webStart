package com.qing.core.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.qing.core.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 部门
 * @TableName sys_dept
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="sys_dept")
@Data
public class Dept extends BaseEntity implements Serializable {

    /**
     * 父部门id
     */
    private String parentId;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 层级（1 根目录 2 单位 3 部门）
     */
    private Integer level;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}