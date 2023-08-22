package com.qing.fapi.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
//@SaCheckLogin
public class TestController {

//    @SaIgnore
    @SaCheckLogin
    @GetMapping("/getList")
    public void getList() {
        System.out.println("请求到了");
    }

//    /**
//     * 登陆后才可调用该方法
//     * @return SaResult
//     */
//    @SaCheckLogin
//    @RequestMapping("/select")
//    public SaResult select(){
//        return SaResult.ok("查询成功");
//    }
//
//    /**
//     * 必须具有指定权限才能进入该方法
//     * @return SaResult
//     */
//    @SaCheckRole("super-admin")
//    @RequestMapping("/delete")
//    public SaResult delete() {
//        return SaResult.ok("删除成功");
//    }
//
//    /**
//     * 注解式鉴权：SaMode.OR 只要具有其中一个权限即可通过校验
//     * @return SaResult
//     */
//    @RequestMapping("/add")
//    @SaCheckPermission(value = {"user-add", "user-all"}, mode = SaMode.OR)
//    public SaResult add() {
//        return SaResult.ok("添加成功");
//    }
//
//    /**
//     * 一个接口在具有权限 user-update 或角色 admin 时可以调通
//     * @return SaResult
//     */
//    @RequestMapping("/update")
//    @SaCheckPermission(value = "user-add", orRole = "admin")
//    public SaResult update() {
//        return SaResult.ok("更新成功");
//    }
//
//    /**
//     * 这个接口测试用
//     * @return SaResult
//     */
//    @RequestMapping("/testPermission")
//    @SaCheckPermission(value = "user123")
//    public SaResult testPermission() {
//        return SaResult.ok("这个接口测试用");
//    }

}

