package com.qing.core.service;

import com.qing.core.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qing.core.vo.fapi.menu.UserMenuVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author ADMIN
* @description 针对表【sys_menu(菜单权限表)】的数据库操作Service
* @createDate 2023-08-24 15:21:30
*/
public interface MenuService extends IService<Menu> {

    List<UserMenuVo> getMenuByUserId(Long userId);
}
