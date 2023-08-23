package com.qing.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qing.core.entity.Dept;
import com.qing.core.service.DeptService;
import com.qing.core.mapper.DeptMapper;
import org.springframework.stereotype.Service;

/**
* @author ADMIN
* @description 针对表【sys_dept(部门)】的数据库操作Service实现
* @createDate 2023-08-23 14:59:27
*/
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept>
    implements DeptService{

}




