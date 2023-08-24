package com.qing.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qing.core.entity.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 秘籍书籍
 * @TableName biz_book
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="biz_book")
@Data
public class BizBook extends BaseEntity implements Serializable {
    /**
     * 名称
     */
    private String name;

    /**
     * 类别（功法、阵法、炼器、炼丹、符箓）
     */
    private String category;

    /**
     * 所属
     */
    private Long deptId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}