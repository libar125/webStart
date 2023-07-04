package com.qing.common.utils;



import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author libarlibarRickSun
 * @version 1.0
 * @data 2020-12-03 17:33
 * @description IP工具类
 */
public class IpUtil {

    /**
     * @author libarlibarRickSun
     * @Description 获取本地IP地址
     **/
    public static String getLocalIP() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException("IP获取失败");
        }
    }

}
