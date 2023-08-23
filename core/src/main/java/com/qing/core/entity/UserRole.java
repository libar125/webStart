package com.qing.core.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 用户角色关联
 * @TableName sys_user_role
 */
@TableName(value ="sys_user_role")
@Data
public class UserRole implements Serializable {
    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 用户ID
     */
    private String userId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}