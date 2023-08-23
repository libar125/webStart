package com.qing.core.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.qing.core.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户信息
 * @TableName sys_user
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="sys_user")
@Data
public class User extends BaseEntity implements Serializable {
    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户姓名
     */
    private String realName;

    /**
     * 所属部门
     */
    private String deptId;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 头像
     */
    private String picture;

    /**
     * 最后登录时间
     */
    private Date loginDate;

    /**
     * 密码更改时间
     */
    private Date updatePwdTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}