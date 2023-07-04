package com.qing.core.controller;

import ResultCodeEnum;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.metadata.IPage;
import ResponseModel;
import com.qing.core.service.impl.SysLogErrorInfoServiceImpl;
import com.qing.core.entity.SysLogErrorInfoEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;
/**
* <p>
    * 系统异常日志控制器
    * </p>
*
* @author libarlibar
* @since 2023-07-04
*/
@RestController
@RequestMapping("/sys-log-error-info-entity")
@Api(value="系统异常日志接口",tags={"系统异常日志"},description = "系统异常日志增删改查相关接口")
public class SysLogErrorInfoController {

    @Autowired
    private SysLogErrorInfoServiceImpl syslogerrorinfoentityService;
    @ApiOperation(value = "列表查询")
    @PostMapping(value = "/query",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel query(@RequestBody QueryEntity<SysLogErrorInfoEntity> queryEntity){
        IPage<SysLogErrorInfoEntity> result = syslogerrorinfoentityService.page(queryEntity.pages(),queryEntity.condition());
        return ResponseModel.success(result);
    }

    @ApiOperation(value = "获取详情")
    @PostMapping("/detail")
    public ResponseModel get(String id){
        SysLogErrorInfoEntity result = syslogerrorinfoentityService.getById(id);
        return result == null ? ResponseModel.error(ResponseModel.error(ResultCodeEnum.RECORD_NOTFOUND)) : ResponseModel.success(result);
    }

    @ApiOperation(value = "增加/修改")
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel save(@RequestBody @Valid SysLogErrorInfoEntity syslogerrorinfoentity, BindingResult result){
        if(result.hasErrors()){
            List<String> message = new ArrayList<>();
            for (ObjectError error : result.getAllErrors()) {
                message.add(error.getDefaultMessage());
            }
            return ResponseModel.error(100,String.join(",",message));
        }
        boolean state = syslogerrorinfoentityService.saveOrUpdate(syslogerrorinfoentity);
        return state ? ResponseModel.success() : ResponseModel.error();
    }

    @ApiOperation(value = "删除")
    @PostMapping("/delete")
    public ResponseModel delete(String[] ids){
        for (String id : ids){
            syslogerrorinfoentityService.removeById(id);
        }
        return ResponseModel.success();
    }

    @ApiOperation(value = "搜索")
    @PostMapping("/search")
    public void search(){
    }
}
