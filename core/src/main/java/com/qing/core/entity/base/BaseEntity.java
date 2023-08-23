package com.qing.core.entity.base;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;


import java.io.Serializable;
import java.util.Date;

/**
 * @author libarAdministrator
 */
@Data
@Accessors(chain = true)
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -7814759188205878196L;

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    public String id;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT, value = "create_time", updateStrategy = FieldStrategy.NEVER)
    private Date createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT, value = "update_time", update = "now()")
    @LastModifiedDate
    private Date updateTime;

    /**
     * 逻辑删除 0=>未删除 1=>已删除
     */
    @TableLogic(value = "0", delval = "1")
    @TableField("is_delete")
    private int isDelete;
}
