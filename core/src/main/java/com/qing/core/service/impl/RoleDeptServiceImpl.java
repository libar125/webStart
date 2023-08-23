package com.qing.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qing.core.entity.RoleDept;
import com.qing.core.service.RoleDeptService;
import com.qing.core.mapper.RoleDeptMapper;
import org.springframework.stereotype.Service;

/**
* @author ADMIN
* @description 针对表【sys_role_dept(角色和部门关联表（当角色数据范围为自定义数据时使用）)】的数据库操作Service实现
* @createDate 2023-08-23 15:07:00
*/
@Service
public class RoleDeptServiceImpl extends ServiceImpl<RoleDeptMapper, RoleDept>
    implements RoleDeptService{

}




