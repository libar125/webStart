package com.qing.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qing.core.entity.Role;
import com.qing.core.service.RoleService;
import com.qing.core.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author ADMIN
* @description 针对表【sys_role(角色信息表)】的数据库操作Service实现
* @createDate 2023-08-23 14:57:32
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




