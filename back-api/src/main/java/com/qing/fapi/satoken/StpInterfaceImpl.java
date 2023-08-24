package com.qing.fapi.satoken;

import cn.dev33.satoken.stp.StpInterface;
import com.qing.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class StpInterfaceImpl implements StpInterface {
    /**
     * 返回一个账号所拥有的权限码集合
     * 即你在调用 StpUtil.login(id) 时写入的标识值。
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return null;

    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        // 本list仅做模拟，实际项目中要根据具体业务逻辑来查询角色
        List<String> list = new ArrayList<>();
        list.add("user");
        list.add("admin");
        list.add("super-admin");
        System.out.println("用户角色列表：" + list);
        return list;
    }

}
