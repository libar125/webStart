package com.qing.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
    private String roleId;

    /**
     * 菜单ID
     */
    private String menuId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}