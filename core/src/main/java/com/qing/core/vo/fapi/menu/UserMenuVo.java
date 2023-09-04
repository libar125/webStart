package com.qing.core.vo.fapi.menu;

import lombok.Data;

@Data
public class UserMenuVo {

    /**
     * 菜单id
     */
    private Long id;

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
     * 权限标识
     */
    private String perms;
}
