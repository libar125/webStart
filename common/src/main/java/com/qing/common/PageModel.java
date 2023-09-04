//package com.qing.common;
//
//import cn.hutool.core.collection.CollUtil;
//import cn.hutool.core.util.ObjectUtil;
//import cn.hutool.core.util.StrUtil;
//import com.baomidou.mybatisplus.core.metadata.OrderItem;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import io.swagger.annotations.ApiModelProperty;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//import java.util.List;
//
///**
// * @Author：dcy
// * @Description: 分页类
// * @Date: 2020/11/26 8:33
// */
//@ToString
//@Getter
//@Setter
//public class PageModel {
//
//    public static final String ORDER_ASC = "asc";
//    public static final String ORDER_DESC = "desc";
//
//    @ApiModelProperty(value = "当前页面", notes = "默认1", example = "1")
//    private long current;
//
//    @ApiModelProperty(value = "每页显示条数", notes = "默认30", example = "30")
//    private long size;
//
//    @ApiModelProperty(value = "排序字段", notes = "对于model字段（多字段用,隔开）")
//    private String sort;
//
//    @ApiModelProperty(value = "排序类型", notes = "asc 或者 desc（多字段用,隔开）,如果多排序字段不传递排序类型，默认升序")
//    private String order;
//
//    /**
//     * 构建分页参数
//     *
//     * @param <T>
//     * @return
//     */
//    public <T> Page<T> build() {
//        Page<T> page = Page.of(getCurrent(), getSize());
//        if (StrUtil.isNotBlank(getOrder()) && StrUtil.isNotBlank(getSort())) {
//            final List<String> sortList = StrUtil.split(getSort(), ',');
//            final List<String> orderList = StrUtil.split(getOrder(), ',');
//            for (int i = 0; i < sortList.size(); i++) {
//                String field = CollUtil.get(sortList, i);
//                if (StrUtil.isBlank(field)) {
//                    break;
//                }
//                field = StrUtil.toUnderlineCase(field);
//                final String orderType = ObjectUtil.defaultIfBlank(CollUtil.get(orderList, i), ORDER_ASC);
//                if (orderType.equals(ORDER_DESC)) {
//                    page.addOrder(OrderItem.desc(field));
//                } else {
//                    page.addOrder(OrderItem.asc(field));
//                }
//            }
//        }
//        return page;
//    }
//
//}
