package com.qing.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qing.core.entity.Log;
import com.qing.core.service.LogService;
import com.qing.core.mapper.LogMapper;
import org.springframework.stereotype.Service;

/**
* @author ADMIN
* @description 针对表【sys_log】的数据库操作Service实现
* @createDate 2023-08-23 15:07:26
*/
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log>
    implements LogService{

}




