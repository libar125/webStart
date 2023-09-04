package com.qing.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qing.core.entity.Menu;
import com.qing.core.service.MenuService;
import com.qing.core.mapper.MenuMapper;
import com.qing.core.vo.fapi.menu.UserMenuVo;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author ADMIN
* @description 针对表【sys_menu(菜单权限表)】的数据库操作Service实现
* @createDate 2023-08-24 15:21:30
*/
@Service
@RequiredArgsConstructor
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService{

    @Override
    public List<UserMenuVo> getMenuByUserId(Long userId){
        return baseMapper.getMenuByUserId(userId);
    }

}




