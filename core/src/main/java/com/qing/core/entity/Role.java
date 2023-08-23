package com.qing.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.qing.core.entity.base.BaseEntity;
import lombok.Data;

/**
 * 角色信息表
 * @TableName sys_role
 */
@TableName(value ="sys_role")
@Data
public class Role extends BaseEntity implements Serializable {
    /**
     * 角色权限字符
     */
    private String roleKey;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 菜单树是否展开（0折叠 1展开 ）
     */
    private Integer isOpen;

    /**
     * 数据范围（1 所有数据 2 所在部门及子部门数据 3 所在部门数据 4 仅本人数据 5 自定义数据）
     */
    private Integer dataScope;

    /**
     * 备注
     */
    private String remark;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}