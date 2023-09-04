//package com.qing.common;
//
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//import java.util.List;
//
///**
// * @Author：dcy
// * @Description: 分页信息返回结果
// * @Date: 2020/11/26 8:33
// */
//@AllArgsConstructor
//@ToString
//@Getter
//@Setter
//public class PageResult<DTO> {
//
//    @ApiModelProperty(value = "当前页")
//    private long current;
//
//    @ApiModelProperty(value = "总页数")
//    private long pages;
//
//    @ApiModelProperty(value = "每页显示条数")
//    private long size;
//
//    @ApiModelProperty(value = "当前满足条件总行数")
//    private long total;
//
//    @ApiModelProperty(value = "分页记录列表")
//    private List<DTO> records;
//
//    public PageResult() {
//
//    }
//
//}
