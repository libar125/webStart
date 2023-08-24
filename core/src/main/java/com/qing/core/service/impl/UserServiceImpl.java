package com.qing.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qing.core.entity.User;
import com.qing.core.service.UserService;
import com.qing.core.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author ADMIN
* @description 针对表【sys_user(用户信息)】的数据库操作Service实现
* @createDate 2023-08-24 15:22:04
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




