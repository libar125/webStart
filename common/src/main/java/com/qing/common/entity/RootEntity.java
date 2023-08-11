//package com.qing.common.entity;
//
//import com.baomidou.mybatisplus.annotation.FieldFill;
//import com.baomidou.mybatisplus.annotation.FieldStrategy;
//import com.baomidou.mybatisplus.annotation.TableField;
//import com.baomidou.mybatisplus.annotation.TableLogic;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import io.swagger.annotations.ApiModelProperty;
//import lombok.Data;
//import lombok.experimental.Accessors;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedDate;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Data
//@Accessors(chain = true)
//@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
//public class RootEntity {
//
//    @ApiModelProperty(value = "创建时间")
//    @TableField(fill = FieldFill.INSERT, value = "create_time", updateStrategy = FieldStrategy.NEVER)
//    @Column(name = "create_time")
//    private Date createTime;
//
//    @ApiModelProperty(value = "修改时间")
//    @TableField(fill = FieldFill.INSERT, value = "update_time", update = "now()")
//    @Column(name = "update_time")
//    @LastModifiedDate
//    private Date updateTime;
//
//    @JsonIgnore
//    @TableLogic(value = "0", delval = "1")
//    @ApiModelProperty(value = "软删除")
//    @TableField("is_deleted")
//    @Column(name = "is_deleted")
//    private int isDeleted;
//
//    public static final String CREATE_TIME = "create_time";
//
//    public static final String UPDATE_TIME = "update_time";
//
//    public static final String IS_DELETED = "is_deleted";
//}
