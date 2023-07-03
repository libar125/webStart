//package com.qing.api.entity;
//
//import javax.persistence.*;
//
//@Entity //告诉JPA这是一个实体类（和数据表映射的类）
//@Table(name = "tbl_user")
//public class User {
//
//    @Id //这是一个主键
//    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
//    private Integer id;
//
//    @Column(name = "last_name",length = 50) //这是和数据表对应的一个列
//    private String lastName;
//
//    @Column //省略默认列名就是属性名
//    private String email;
//
//
//
//}
