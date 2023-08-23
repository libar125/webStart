package com.qing.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qing.core.entity.User;
import com.qing.core.service.UserService;
import com.qing.core.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author ADMIN
* @description 针对表【sys_user(用户信息)】的数据库操作Service实现
* @createDate 2023-08-23 11:34:37
*/
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    private final UserMapper userMapper;

    @Override
    public List<String> getPermissionListByUserId(String id){
        userMapper.selectById("是23");
        return null;
    }
}




