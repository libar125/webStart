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
 * 字典
 * @TableName sys_dict
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="sys_dict")
@Data
public class Dict extends BaseEntity implements Serializable {

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 字典名称
     */
    private String name;

    /**
     * 字典代码
     */
    private String code;

    /**
     * 字典值
     */
    private String value;

    /**
     * 是否是字典类型（1 字典类型 2 字典项）
     */
    private Integer isType;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 备注
     */
    private String remark;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}