package com.qing.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;

import java.io.Serializable;

/**
 * @author libarAdministrator
 */
@Data
@Accessors(chain = true)
@MappedSuperclass
public class BaseEntity extends RootEntity implements Serializable {
    private static final long serialVersionUID = -7814759188205878196L;

    @ApiModelProperty(value = "自增主键")
    @TableId(type = IdType.AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public static final String ID = "id";
}
