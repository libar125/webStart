//package com.qing.common.utils;
//
//import cn.hutool.core.util.RandomUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * 生成8位随机数
// *
// */
//@Component
//public class NumberUtils {
//
//    @Autowired
//    RedisUtils redisUtils;
//
//    /**
//     * 获取8位不重复随机码（取当前时间戳转化为十六进制）
//     * @author libarShelWee
//     * @return
//     */
//    public String toHex(){
//        String str = Integer.toHexString((int)System.currentTimeMillis());
//        if (redisUtils.get(str,Integer.class) != null){
//            str = RandomUtil.randomString(8);
//        }
//        redisUtils.set(str,1);
//        return str;
//    }
//}
