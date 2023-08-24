package com.qing.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qing.core.entity.Role;
import com.qing.core.entity.UserRole;
import com.qing.core.service.UserRoleService;
import com.qing.core.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author ADMIN
* @description 针对表【sys_user_role(用户角色关联)】的数据库操作Service实现
* @createDate 2023-08-24 15:22:12
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

    @Override
    public List<Role> getRoleByUserId(Long userId){
        return baseMapper.getRoleByUserId(userId);
    }

}




