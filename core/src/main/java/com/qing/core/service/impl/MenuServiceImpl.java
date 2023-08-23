package com.qing.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qing.core.entity.Menu;
import com.qing.core.service.MenuService;
import com.qing.core.mapper.MenuMapper;
import org.springframework.stereotype.Service;

/**
* @author ADMIN
* @description 针对表【sys_menu(菜单权限表)】的数据库操作Service实现
* @createDate 2023-08-23 15:07:15
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService{

}




