//package com.qing.common.utils;
//
//import com.alibaba.fastjson.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class ZhongxinUtil {
//    private static Logger logger = LoggerFactory.getLogger(ZhongxinUtil.class);
//
//    @Value("${zhongxin.out_member_no}")
//    private String out_member_no;
//
//    private static String public_key="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCNm+Dq7oFOfl4M3BBH0Y/CvKaPfx+dbNjCaDgXIizjlumLOxz853sXzdIZ/ZesPD9SjQfQ1Jun6nSvDCjl9KT+foicjHSOUhQf5pFHKhKjDsam3mnLjrWrTjZE2L5G6/RRCpby082DhkU7FtJYa8ieVz+ZJqik3dkFOi+xD1h+8wIDAQAB";
//
//    @Value("${zhongxin.md5key}")
//    private  String md5key;
//
//    @Value("${zhongxin.generate}")
//    private String generate;
//
//    @Value("${zhongxin.getH5ContractInfo_dev}")
//    private String getH5ContractInfo_dev;
//    @Value("${zhongxin.getH5ContractInfo_test}")
//    private String getH5ContractInfo_test;
//
//    @Value("${zhongxin.query}")
//    private String query;
//
//    @Value("${zhongxin.zx_web_back_jump_url}")
//    private String webNotifyUrl;
//
//    @Value("${zhongxin.zx_contract_notify_url}")
//    private String serviceNotifyUrl;
//
//    @Value("${zhongxin.private_key}")
//    private String private_key;
//
//    /**
//     * 创建合同
//     * @param name 姓名
//     * @param idCard 身份证号码
//     * @param serialNumber 众薪合同流水号  随机生成
//     *
//     * @return
//     */
//    public String generate(String name,String idCard,String serialNumber) throws Exception {
//        JSONObject map=new JSONObject();
//        map.put("outMemberNo",out_member_no);
//        map.put("serialNumber",serialNumber);
//        map.put("contractNo","1163708131004383232");
//        map.put("webNotifyUrl","http://www.baidu.com");
//        map.put("serviceNotifyUrl","http://1.14.61.169:6001/zhongxin/call-back");
//        JSONObject jsonObject=new JSONObject();
//        jsonObject.put("name",name);
//        jsonObject.put("idCard",idCard);
//        String sign = RSAUtils.encryptByPublicKey(JSONObject.toJSONString(jsonObject),public_key);
//        map.put("sign",sign);
//        String s = HttpUtils.doPost(generate, map.toJSONString());
//        return s;
//    }
//
//
//   //签约状态查询
//    public String getH5ContractInfo(String encryptStr) throws Exception {
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("outMemberNo",out_member_no);
//        JSONObject json = new JSONObject();
//        json.put("serialNumber",encryptStr);
//        logger.info("签约状态查询参数"+jsonObject.toString());
//        String sign = RSAUtils.encryptByPublicKey(JSONObject.toJSONString(json),public_key);
//       jsonObject.put("sign",sign);
//        String res = HttpUtils.doPost(getH5ContractInfo_dev, jsonObject.toJSONString());
//        return res;
//    }
//    /**
//     * 单笔提现
//     * @param outerOrderNo
//     * @param name
//     * @param mobile
//     * @param certificateNo
//     * @param predictAmount
//     * @param payAccount
////     * @param cardType
////     * @param salaryType
////     * @param projectName
////     * @param payType
////     * @param cardAttribute
//     * @return
//     */
//    public  String  doSign(String outerOrderNo, String name, String mobile, String certificateNo, String predictAmount,
//                                 String payAccount, String cardType, String salaryType, String projectName, String payType,String cardAttribute,String remark){
//
//
//        Map<String, Object> map = new HashMap<>();
//        //输入商户号
//       // String memberNo = "";
//        map.put("outMemberNo",out_member_no);
//        map.put("outerOrderNo", outerOrderNo);
//        map.put("name", name);
//        map.put("certificateNo", certificateNo);
//        map.put("predictAmount", predictAmount);
//        String signs = Md5EncryptUtils.sign(map,md5key);
//        map.put("Md5Key", signs);
//
//        map.put("notifyUrl", "http://apis.bpotop.com/bpotop_trade/test");
//        map.put("mobile", mobile);
//       // map.put("certificateType","身份证");//证件类型
//        map.put("cardType", cardType);
//        map.put("salaryType", salaryType);
//        map.put("projectName", projectName);
//        map.put("payType", payType);
//        map.put("cardAttribute", cardAttribute);
//        map.put("payAccount", payAccount);
//
//        map.put("signType","RSA");
//        map.put("service","bpotop.zx.pay.order");
//        map.put("charset","UTF-8");
//        map.put("version","1.1");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String createTime = sdf.format(new Date());
//        map.put("createTime",createTime);
//        map.put("remark",remark);
//        String jsonStr = JSONObject.toJSONString(map);
//        try {
//            //使用公钥加密
//            String encryptStr = RSA.encryptPub(jsonStr,public_key);
//            JSONObject mapParam = new JSONObject();
//            mapParam.put("signType","RSA");
//            mapParam.put("service","bpotop.zx.pay.order");
//            mapParam.put("charset","UTF-8");
//            mapParam.put("version","1.1");
//            mapParam.put("outMemberNo",out_member_no);
//            mapParam.put("sign",encryptStr);
//            logger.info("单笔请求请求参数：{}",JSONObject.toJSONString(mapParam));
//            return JSONObject.toJSONString(mapParam);
//        } catch (Exception e) {
//            logger.info("加密/发送失败：{}",e);
//        }
//        return null;
//    }
//
//    /**
//     *
//     * @param outerOrderNo 商户订单号
//     * @param name 收款人姓名
//     * @param mobile 收款人手机号
//     * @param certificateNo 收款人身份证号
//     * @param predictAmount 输入转账金额（单位分）
//     * @param payAccount 收款人账号
//     * @param cardType 卡类型：DC借记卡，CC信用卡（暂不支持）
//     * @param salaryType 发放类型（0：工资，1：奖金，2：绩效，3：劳务，4：个人经营所得，5：其他）
//     * @param projectName 项目名称
//     * @param payType 支付类型（1：银行卡）
//     * @param cardAttribute 卡属性:(C:对私 ,B：对公）暂时不支持对公
//     * @return
//     */
//    public String dosign2(String outerOrderNo, String name, String mobile, String certificateNo, String predictAmount,
//                         String payAccount, String cardType, String salaryType, String projectName, String payType, String cardAttribute){
//        Map<String,Object> map = new HashMap<>();
//        //拼接md5Key
//        map.put("outMemberNo",out_member_no);
//        map.put("outerOrderNo", outerOrderNo);
//        map.put("name", name);
//        map.put("certificateNo", certificateNo);
//        map.put("predictAmount", predictAmount);
//        String signs = Md5EncryptUtils.sign(map,md5key);
//
//        map.put("charset","UTF-8");
//        map.put("mobile", mobile);
//        map.put("version","1.1");
//        map.put("service","bpotop.zx.pay.order");
//        map.put("Md5Key", signs);
//        map.put("notifyUrl", "http://1.14.61.169:6001/zhongxin/pay-call-back");
//        map.put("cardType", cardType);
//        map.put("salaryType", salaryType);
//        map.put("projectName", projectName);
//        map.put("payType", payType);
//        map.put("cardAttribute", cardAttribute);
//        map.put("payAccount", payAccount);
//        String jsonStr = JSONObject.toJSONString(map);
//        try {
//            //使用公钥加密
//            String encryptStr = RSA.encryptPub(jsonStr,public_key);
//            JSONObject mapParam = new JSONObject();
//            mapParam.put("signType","RSA");
//            mapParam.put("service","bpotop.zx.pay.order");
//            mapParam.put("charset","UTF-8");
//            mapParam.put("version","1.0");
//            mapParam.put("outMemberNo",out_member_no);
//            mapParam.put("sign",encryptStr);
//            logger.info("单笔请求请求参数：{}",JSONObject.toJSONString(mapParam));
//            return JSONObject.toJSONString(mapParam);
//        } catch (Exception e) {
//            logger.info("加密/发送失败：{}",e);
//        }
//        return null;
//    }
//
//
//    /**
//     * 查询接口
//     */
//    public String queryOrderInfo(String orderNo) throws Exception {
//        Map<String, Object> requestMap = new HashMap<>();
//        //商户号
//        requestMap.put("outMemberNo",out_member_no);
//        logger.info("商户号:"+out_member_no);
//        //订单号
//        requestMap.put("outerOrderNo",orderNo);
//        requestMap.put("service", "bpotop.zx.pay.order");
//        requestMap.put("version", "1.0");
//        requestMap.put("signType", "RSA");
//        requestMap.put("charset", "UTF-8");
//        String jsonStr = JSONObject.toJSONString(requestMap);
//        String encryptStr = RSA.encryptPub(jsonStr,public_key);
//        Map<String, Object> requestMap2 = new HashMap<>();
//        requestMap2.put("outMemberNo", "");
//        requestMap2.put("sign", encryptStr);
//        logger.info("单笔查询请求参数：{}",JSONObject.toJSONString(requestMap2));
//        String resultJsonStr = HttpUtils.doPost("http://39.107.15.64:8090/bpotop_trade/order_query", JSONObject.toJSONString(requestMap2));
//        logger.info("单笔查询响应参数：{}",resultJsonStr);
//        return resultJsonStr;
//    }
//}
