package com.qing.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qing.core.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.Data;

/**
 * 角色菜单关联
 * @TableName sys_role_menu
 */
@TableName(value ="sys_role_menu")
@Data
public class RoleMenu implements Serializable {
    /**
     * 角色ID
     */
    @TableId
    private Long roleId;

    /**
     * 菜单ID
     */
    @TableId
    private Long menuId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}