package com.qing.fapi.satoken;

import cn.dev33.satoken.stp.StpInterface;
import com.qing.core.entity.Role;
import com.qing.core.service.MenuService;
import com.qing.core.service.UserRoleService;
import com.qing.core.service.UserService;
import com.qing.core.vo.fapi.menu.UserMenuVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class StpInterfaceImpl implements StpInterface {

    private final UserRoleService userRoleService;

    private final MenuService menuService;

    /**
     * 返回一个账号所拥有的权限码集合
     * 即你在调用 StpUtil.login(id) 时写入的标识值。
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        List<UserMenuVo> menuList = menuService.getMenuByUserId((Long) loginId);
        return menuList.stream().map(UserMenuVo::getPerms).collect(Collectors.toList());
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        List<Role> roleList = userRoleService.getRoleByUserId((Long) loginId);
        return roleList.stream().map(Role::getRoleKey).collect(Collectors.toList());
    }

}
