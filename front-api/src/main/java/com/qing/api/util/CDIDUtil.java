package com.qing.api.util;


import com.alibaba.fastjson.JSONObject;

import com.qing.api.vo.CDID.CDIDVo;
import com.qing.api.vo.CDID.ReqBizPackage;
import com.qing.api.vo.CDID.apply.ApplyRequestBizData;
import com.qing.api.vo.CDID.apply.ApplyResponseBizData;
import com.qing.api.vo.CDID.verify.VerifyBizDataVo;
import com.qing.api.vo.CDID.verify.VerifyResponseBizData;
import com.qing.common.ResponseModel;
import com.qing.common.ResultCodeEnum;
import com.qing.common.utils.CDID.CDIDSignUtil;
import com.qing.common.utils.CDID.EncodesUtil;
import com.qing.common.utils.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CDIDUtil {

    private static final Logger logger = LoggerFactory.getLogger(CDIDUtil.class);

    private static final String public_encrypt_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCl23X1jCttl9A93NT1Uev8/5rXZezm83BwbJKQQFi8onP7lBRTBQh8/ahyhMX8Qc2QKEq4/t58Q0NVZE2/Yb8OqZk4LEu1pCt2ra57DSvgMQ41oxDere4kyTYAqFuMJoQQgEmyYpzpHQu1GlSYRtbJ3Oxd/JqHfOSjPVYJaDEBswIDAQAB";

    private static final String private_key = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJtxSZ+l/BxsPQtzdVW+RMeGpjMJGoGXzSNQiPsXQdL0Apo72aXpRLizn6BNNexrO12WwfIKUlUzZ5WrUKvyQzKTwbKL2PWL7FCWdcqgi1KJ9tygfolGuSqLaY1lTB1HubSuLaTbpmiS5Khjdwkpg5VAZH2sFhz8hKfc1ir5tBFfAgMBAAECgYBo7pwFwtYjFcpLvaBaxnvFuZbeYunay+/2Q/qEjhmoX4KWPYranlL+4HsEirq5I1ZLAmdgjikwTOhDOAfYW02Se3+sproTyqAy3/qimk/MqbW/bT6whfYocZlZbnCdgeaPK+xyhRDYPDrRGCmiYLbuDdflSX3aNkbgFMNhRAuIKQJBANrxMQUMxiNe15zqq9b9Owm6hFWCQvFzBlHBebaQUge+lK4g6WIm0L7mfeXuo2Fc0M8j++hukxsmFhSpTDXv/JUCQQC1wKTy+MXaX3YXkoYKrfywbdMJMr0OdfboJ7KcEmaOZ6N6XGXrHS437lOUkIk6VCEEFB+v1b1YOS5O+vwVFyUjAkBG5NSPowxBhcNhXyeXbNYCF3AkVBKjJjDEplZoBCFbup1gKO4JRzJOrknT+0rSCwDeIfO+1pcxskpyFEPGL1hlAkBOduV/M6EO/mlYEdymXaiabj9OWEZAKPM4FHNKZ7M4xUtRNvSVBRr/8HbKy39C3DEItrtbSNYecUkptbcAT+arAkEAlCqVfwydy7oM7+lPU39jmPv6Mkj1I0qc/x+j2jp8gkJj91pogQOzQQd/wpNywYDCORD2r84lPyK+JrP+OjODQw==";

    private static final String public_sign_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCDN70NRLHpbemf3wDwBqgVi7oClnERyel6nGXBd6ng8MNMDyWc8DG3QPgbGhbWikN8559rlzXPkowqx2ZqQUfLWcMSZ0YqMh7wdT25uQfjmQJ2t5lZt5ZjsWuJit5mjIyDaQgymBaB3Lnvk+5Z6WFhrkNg0zSVs10JusXwiDhS3wIDAQAB";

    private static final String org_code = "29fb7b4673014b0da0833dafbcec9848";

    private static final String auth_mode = "0x42";

    private static final Integer biz_type = 6000;

    public static String URL_VERIFICATION = "http://api.easyctid.cn/ctid/v1/verification";

    public static String URL_APPLY = "http://api.easyctid.cn/v1/apply";


    public CDIDSignUtil cdidSignUtil = new CDIDSignUtil();


    public ResponseModel verify(String name, String idNo, String photoData) throws Exception{

        ResponseModel apply = createApply();

        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(apply.getData());
        String bsn = String.valueOf(jsonObject.get("bsn"));
        logger.info("人脸认证申请成功bsn{}",bsn);

        return verification(bsn,name,idNo,photoData);
    }

    public ResponseModel createApply() throws Exception {
        ReqBizPackage<ApplyRequestBizData> reqBizPackage = new ReqBizPackage<>();
        reqBizPackage.setBizType(biz_type);
        reqBizPackage.setOrgCode(org_code);
        reqBizPackage.setBizData(new ApplyRequestBizData());
        reqBizPackage.getBizData().setAuthMode(auth_mode);
        String reqBizPackageJson = JSONObject.toJSONString(reqBizPackage);
        //2、签名
        byte[] signArray = cdidSignUtil.sign(private_key, reqBizPackageJson.getBytes());
        String signString = EncodesUtil.encodeBase64(signArray);
        logger.info("apply:人脸认证请求参数reqBizPackage{}",signString);
        CDIDVo cdidVo = new CDIDVo();
        cdidVo.setSign(signString);
        cdidVo.setBizPackage(reqBizPackageJson);

        String requestParam = JSONObject.toJSONString(cdidVo);
        logger.info("apply:人脸认证请求参数校验{}",requestParam);

        String result = HttpUtils.doPost(URL_APPLY, requestParam);
        logger.info("人脸认证返回结果{}",result);

        CDIDVo cdidVoResult =  JSONObject.parseObject(result, CDIDVo.class);

        byte[] signByte = EncodesUtil.decodeBase64(cdidVoResult.getSign());

        //对返回结果进行验签
        if (!cdidSignUtil.verifySign(public_sign_key, signByte, cdidVoResult.getBizPackage().getBytes())) {
            System.out.println("--------生码请求请求成功，对返回结果验签未通过");
            return ResponseModel.error("对返回结果验签未通过");
        }

        ApplyResponseBizData responseBizData = JSONObject.parseObject(cdidVoResult.getBizPackage(), ApplyResponseBizData.class);
        String resultCode = responseBizData.getResultCode();

        if (resultCode.equals("0")){
            String bsn = responseBizData.getBizData().getBsn();
            String randomNumber = responseBizData.getBizData().getRandomNumber();
            ApplyResponseBizData.BizData bizData = responseBizData.getBizData();
            return ResponseModel.success(bizData);
        }else{
            return ResponseModel.error(ResultCodeEnum.FACE_AUTH_FAIL);
        }
    }



    public ResponseModel verification(String bsn,String name,String idNo,String photoData) throws Exception {
        ReqBizPackage<VerifyBizDataVo> reqBizPackage = new ReqBizPackage<>();
        reqBizPackage.setBizData(new VerifyBizDataVo());
        reqBizPackage.setBizType(6000);
        reqBizPackage.setBsn(bsn);
        reqBizPackage.setOrgCode(org_code);
        reqBizPackage.getBizData().setAuthMode(auth_mode);
        reqBizPackage.getBizData().setPhotoData(photoData);

        //请求保留数据加密字段
        VerifyBizDataVo.AuthApplyRetainData authApplyRetainDataVo = new VerifyBizDataVo.AuthApplyRetainData();
        authApplyRetainDataVo.setName(name);
        authApplyRetainDataVo.setIdNo(idNo);
        String s = JSONObject.toJSONString(authApplyRetainDataVo);
        byte[] res = cdidSignUtil.encryptAES(public_encrypt_key, s.getBytes());

        reqBizPackage.getBizData().setAuthApplyRetainData(EncodesUtil.encodeBase64(res));
        String createApplyJson = JSONObject.toJSONString(reqBizPackage);

        //2、签名
        byte[] signArray = cdidSignUtil.sign(private_key, createApplyJson.getBytes());
        String signString = EncodesUtil.encodeBase64(signArray);

        //3、请求包组装
        CDIDVo cdidVo = new CDIDVo();
        cdidVo.setSign(signString);
        cdidVo.setBizPackage(createApplyJson);
        String requestParam = JSONObject.toJSONString(cdidVo);

        logger.info("verification:人脸认证请求参数校验{}",requestParam);

        String result;
        try {
            result = HttpUtils.doPost(URL_VERIFICATION, requestParam);
            System.out.println("verification:人脸认证核验请求响应: " + result);
        } catch (Exception e) {
            return  ResponseModel.error("人脸认证核验请求响应失败");
        }

        CDIDVo createApplyResultJson = JSONObject.parseObject(result,CDIDVo.class);
        VerifyResponseBizData responseBizData = JSONObject.parseObject(createApplyResultJson.getBizPackage(), VerifyResponseBizData.class);
        //对返回结果进行验签
        byte[] signByte = EncodesUtil.decodeBase64(createApplyResultJson.getSign());
        logger.info("signByte{}",signByte);
        if (!cdidSignUtil.verifySign(public_sign_key, signByte, createApplyResultJson.getBizPackage().getBytes())) {
            System.out.println("--------生码请求请求成功，对返回结果验签未通过");
            return  ResponseModel.error("对返回结果验签未通过");
        }

        //如果返回结果为0表示成功
        if ("0".equals(responseBizData.getResultCode())) {
            VerifyResponseBizData.BizData bizData = responseBizData.getBizData();
            return  ResponseModel.success(bizData);
        } else {
            return  ResponseModel.error(ResultCodeEnum.FACE_AUTH_FAIL);
        }
    }

}
