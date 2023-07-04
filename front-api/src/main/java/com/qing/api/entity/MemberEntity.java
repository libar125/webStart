package com.qing.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.qing.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;


/**
 * @author libarAdministrator
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("member")
@ApiModel(value="MemberEntity对象", description="用户表")
public class MemberEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "手机号")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "是否人脸认证")
    @TableField("is_auth")
    private Integer isAuth;

    @ApiModelProperty(value = "是否人脸认证")
    @TableField("role")
    private Integer role;

    @ApiModelProperty(value = "'推荐人'")
    @TableField("parent_id")
    private Integer parentId;

    @TableField(exist = false)
    private List<MemberEntity> memberList;
}
