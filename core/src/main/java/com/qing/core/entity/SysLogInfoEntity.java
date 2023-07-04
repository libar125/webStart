package com.qing.core.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.qing.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javafx.beans.property.adapter.JavaBeanBooleanPropertyBuilder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotBlank;
/**
 * <p>
 * 系统操作日志
 * </p>
 *
 * @author libarlibar
 * @since 2023-07-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_log_info")
@ApiModel(value="SysLogInfoEntity对象", description="系统操作日志")
public class SysLogInfoEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "功能模块")
    private String module;

    @ApiModelProperty(value = "操作类型")
    private String type;

    @ApiModelProperty(value = "操作描述")
    private String message;

    @ApiModelProperty(value = "请求参数")
    private String reqParams;

    @ApiModelProperty(value = "响应参数")
    private String resParams;

    @ApiModelProperty(value = "耗时")
    private Long takeUpTime;

    @ApiModelProperty(value = " 操作用户id")
    private Long userId;

    @ApiModelProperty(value = "操作用户名称")
    private String userName;

    @ApiModelProperty(value = "操作方法")
    private String method;

    @ApiModelProperty(value = "请求地址")
    private String uri;

    @ApiModelProperty(value = "请求ip")
    private String ip;

    @ApiModelProperty(value = "版本号")
    private String version;

    @ApiModelProperty(value = "逻辑删除(1:删除 0:未删除)")
    private Integer isDeleted;
}
