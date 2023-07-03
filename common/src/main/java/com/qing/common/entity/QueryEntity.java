//package com.qing.common.entity;
//
//import com.baomidou.mybatisplus.annotation.TableField;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.core.toolkit.StringUtils;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import io.swagger.annotations.ApiModelProperty;
//import lombok.Data;
//import lombok.experimental.Accessors;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.beanutils.BeanUtils;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Slf4j
//@Data
//@Accessors(chain = true)
//public class QueryEntity<T> {
//    @ApiModelProperty(value = "当前分页", example = "1", required = true)
//    private int page = 1;
//    @ApiModelProperty(value = "每页记录数量", example = "20", required = true)
//    private int pageSize = 20;
//    @ApiModelProperty(value = "排序方式")
//    private QuerySort sort;
//    @ApiModelProperty(value = "过滤条件")
//    private T query;
//
//
//    public IPage<T> pages() {
//        return new Page<>(getPage(), getPageSize());
//    }
//
//    public QueryWrapper<T> condition() {
//        QueryWrapper<T> condition = new QueryWrapper<>();
//        if(null != query){
//            condition.allEq(Query(), false);
//
//        }
//
//        if (sort == null) {
//            sort = new QuerySort();
//        }
//        if (StringUtils.isNotBlank(sort.getField())) {
//            condition.orderBy(true, !sort.getType().equals("desc"), sort.getField());
//        }
//        return condition;
//    }
//
//    public Map<String, String> Query() {
//
//        Map<String, String> map = null;
//        Map<String,String> cond = new HashMap<>();
//        try {
//            map = BeanUtils.describe(query);
//        } catch (Exception e) {
//
//        }
//        if (map.containsKey("class")) {
//            map.remove("class");
//        }
//        if (map.containsKey("isDelete")) {
//            map.remove("class");
//        }
//
//        //通过反射获取数据库查询条件并过滤（驼峰问题）
//        Class clazz = query.getClass();
//
//        for (String key : map.keySet()) {
//            //获取TableField注解
//            try {
//                TableField tableField = clazz.getDeclaredField(key).getAnnotation(TableField.class);
//                cond.put(tableField.value(),map.get(key));
//            } catch (Exception e) {
//                log.debug(e.toString());
//            }
//            //读取常量字段
//            try {
//                String fieldName = clazz.getField(key.toUpperCase()).get(clazz).toString();
//                cond.put(fieldName,map.get(key));
//            }catch (Exception e){
//                log.debug(e.toString());
//            }
//        }
//
//        return cond;
//    }
//
//    @Data
//    private class QuerySort {
//        @ApiModelProperty(value = "排序方式", example = "asc/desc", required = false)
//        private String type = "desc";
//        @ApiModelProperty(value = "排序字段", example = "id", required = false)
//        private String field = "id";
//    }
//
//    public String FirstCase(String str){
//        char[] chars = str.toCharArray();
//        chars[0] -=32;
//        return String.valueOf(chars);
//
//    }
//}
