package com.qing.fapi.controller;

import com.qing.common.ResponseModel;
import com.qing.common.utils.TestUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
@Api(tags = "测试")
public class TestController {

    @ApiOperation(value = "测试")
    @PostMapping("/test")
    public ResponseModel addChannel(){
        return ResponseModel.success(TestUtil.aa());
    }
}
