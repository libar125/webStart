package com.qing.core.mapper;

import com.qing.core.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qing.core.vo.fapi.menu.UserMenuVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author ADMIN
* @description 针对表【sys_menu(菜单权限表)】的数据库操作Mapper
* @createDate 2023-08-24 15:21:30
* @Entity com.qing.core.entity.Menu
*/
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 根据
     * @return
     */
    List<UserMenuVo> getMenuByUserId(@Param("userId") Long userId);

}




