package com.qing.core.mapper;

import com.qing.core.entity.Role;
import com.qing.core.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author ADMIN
* @description 针对表【sys_user_role(用户角色关联)】的数据库操作Mapper
* @createDate 2023-08-24 15:22:12
* @Entity com.qing.core.entity.UserRole
*/
public interface UserRoleMapper extends BaseMapper<UserRole> {

    List<Role> getRoleByUserId(Long userId);
}




