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
 * 菜单权限表
 * @TableName sys_menu
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="sys_menu")
@Data
public class Menu extends BaseEntity implements Serializable {
    /**
     * 父菜单ID
     */
    private Long parentId;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     * 访问路径
     */
    private String url;

    /**
     * 组件名称
     */
    private String path;

    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    private String type;

    /**
     * 菜单状态（1正常 2停用 3删除）
     */
    private Integer state;

    /**
     * 权限标识
     */
    private String perms;

    /**
     * 显示状态（0 显示 1隐藏）
     */
    private Integer visible;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 
     */
    private String activeMenu;

    /**
     * 备注
     */
    private String remark;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}