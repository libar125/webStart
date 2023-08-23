package com.qing.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 角色和部门关联表（当角色数据范围为自定义数据时使用）
 * @TableName sys_role_dept
 */
@TableName(value ="sys_role_dept")
@Data
public class RoleDept implements Serializable {
    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 部门ID
     */
    private String deptId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}