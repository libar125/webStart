package com.qing.fapi.controller;

import cn.dev33.satoken.annotation.*;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 徐一杰
 * @date 2022/9/23 16:38
 * @description
 */
@RestController
@RequestMapping("/test")
@SaCheckLogin
public class TestController {

    /**
     * 此接口加上了 @SaIgnore 可以游客访问
     * @return
     */
    @SaIgnore
    @RequestMapping("/getList")
    public SaResult getList() {
        return SaResult.ok("无需登录接口");
    }

    /**
     * 登陆后才可调用该方法
     * @return
     */
    @SaCheckLogin
    @RequestMapping("/select")
    public SaResult select(){
        return SaResult.ok("查询成功");
    }

    /**
     * 必须具有指定权限才能进入该方法
     * @return
     */
    @SaCheckRole("super-admin")
    @RequestMapping("/delete")
    public SaResult delete() {
        return SaResult.ok("删除成功");
    }

    /**
     * 注解式鉴权：SaMode.OR 只要具有其中一个权限即可通过校验
     * @return
     */
    @RequestMapping("/add")
    @SaCheckPermission(value = {"user-add", "user-all"}, mode = SaMode.OR)
    public SaResult add() {
        return SaResult.ok("添加成功");
    }

    /**
     * 一个接口在具有权限 user-update 或角色 admin 时可以调通
     * @return
     */
    @RequestMapping("/update")
    @SaCheckPermission(value = "user-add", orRole = "admin")
    public SaResult update() {
        return SaResult.ok("更新成功");
    }

    /**
     * 这个接口测试用
     * @return
     */
    @RequestMapping("/testPermission")
    @SaCheckPermission(value = "user123")
    public SaResult testPermission() {
        return SaResult.ok("这个接口测试用");
    }

}

