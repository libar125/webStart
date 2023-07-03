package com.qing.common.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RoundPointUtil {

    /**
     * @param lat 当前纬度
     * @param lon 当前经度
     * @param raidus 半径
     * @return Map
     */
    public static Map<String,Double> getRoundPoint(double lat, double lon, long raidus){
        HashMap<String,Double>  map = new HashMap<>();
        // 赤道周长24901英里 1609是转换成米的系数
        Double degree = (24901 * 1609) / 360.0;
        Double dpmLat = 1/degree;
        Double radiusLat = dpmLat * raidus;
        Double minLat = lat - radiusLat;
        Double maxLat = lat + radiusLat;

        Double mpdLng = degree * Math.cos(lat * (Math.PI/180));
        Double dpmLng = 1/mpdLng;
        Double radiusLng = dpmLng * raidus;
        Double minLng = lon - radiusLng;
        Double maxLng = lon + radiusLng;
        //return new double[] { minLat, minLng, maxLat, maxLng };
        map.put("minLat", minLat);
        map.put("minLng", minLng);
        map.put("maxLat", maxLat);
        map.put("maxLng", maxLng);
        return map;
    }


//    private static double EARTH_RADIUS = 6371.393D;
//
//    public static double[] getScope(double longitude,double latitude,double raidus){
//        //先计算查询点的经纬度范围
//        double PI = 3.14159265;
//        /*double EARTH_RADIUS = 6378137;
//        double RAD = Math.PI / 180.0;*/
//
//        Double degree = (24901 * 1609) / 360.0;
//        double raidusMile = raidus * 1000;
//
//        Double dpmLat = 1 / degree;
//        Double radiusLat = dpmLat * raidusMile;
//        Double minLat = latitude - radiusLat;
//        Double maxLat = latitude + radiusLat;
//
//        Double mpdLng = degree * Math.cos(latitude * (PI / 180));
//        Double dpmLng = 1 / mpdLng;
//        Double radiusLng = dpmLng * raidusMile;
//        Double minLng = longitude - radiusLng;
//        Double maxLng = longitude + radiusLng;
//
//        return new double[] { minLat,maxLat,minLng, maxLng};
//    }

//    public static double[] getScopes(RepairStoreDto repairStoreDto){
//        //先计算查询点的经纬度范围
//        double r = 6371;//地球半径千米
//        double dis = 0.5;//0.5千米距离
//        double dlng =  2*Math.asin(Math.sin(dis/(2*r))/Math.cos(repairStoreDto.getLat()*Math.PI/180));
//        dlng = dlng*180/Math.PI;//角度转为弧度
//        double dlat = dis/r;
//        dlat = dlat*180/Math.PI;
//        double minlat =repairStoreDto.getLat()-dlat;
//        double maxlat = repairStoreDto.getLat()+dlat;
//        double minlng = repairStoreDto.getLon() -dlng;
//        double maxlng = repairStoreDto.getLon() + dlng;
////      Object[] valuess = {minlng,maxlng,minlat,maxlat};
//        return new double[] { minlng,maxlng,minlat,maxlat};
//    }


//    private static double rad(double d)
//    {
//        return (d * 3.1415926535897931D) / 180D;
//    }
//
//    public static double getDistance(double lat1, double lng1, double lat2, double lng2)
//    {
//        double radLat1 = rad(lat1);
//        double radLat2 = rad(lat2);
//        double a = radLat1 - radLat2;
//        double b = rad(lng1) - rad(lng2);
//        double s = 2D * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2D), 2D) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2D), 2D)));
//        s *= EARTH_RADIUS;
//        s = Math.round(s * 1000D);
//        return s;
//    }

}
