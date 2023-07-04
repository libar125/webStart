package com.qing.core.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qing.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 省份表
 * </p>
 *
 * @author libarlibar
 * @since 2023-07-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_province")
@ApiModel(value="SysProvinceEntity对象", description="省份表")
public class SysProvinceEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "省份名称")
    private String name;

    @ApiModelProperty(value = "是否启用 1-启用; 0-禁用")
    private Boolean status;

    @ApiModelProperty(value = "创建人")
    private String createBy;


}
