package com.qing.core.vo.fapi.user;

import lombok.Data;

import java.util.Date;


@Data
public class UserPageVo {

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
    private String deptName;

    /**
     * 头像
     */
    private String picture;

    /**
     * 最后登录时间
     */
    private Date loginDate;

    /**
     * 创建者
     */
    private String createByUserName;

}
