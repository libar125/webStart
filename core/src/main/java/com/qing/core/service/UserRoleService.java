package com.qing.core.service;

import com.qing.core.entity.Role;
import com.qing.core.entity.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author ADMIN
* @description 针对表【sys_user_role(用户角色关联)】的数据库操作Service
* @createDate 2023-08-24 15:22:12
*/
public interface UserRoleService extends IService<UserRole> {

    /**
     * 获取用户角色
     * @param userId 用户id
     * @return 角色列表
     */
    List<Role> getRoleByUserId(Long userId);
}
