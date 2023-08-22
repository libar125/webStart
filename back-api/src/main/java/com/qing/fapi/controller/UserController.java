//package com.qing.fapi.controller;
//
//import cn.dev33.satoken.annotation.SaIgnore;
//import cn.dev33.satoken.basic.SaBasicUtil;
//import cn.dev33.satoken.secure.SaBase64Util;
//import cn.dev33.satoken.secure.SaSecureUtil;
//import cn.dev33.satoken.stp.SaTokenInfo;
//import cn.dev33.satoken.stp.StpUtil;
//import cn.dev33.satoken.util.SaResult;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.HashMap;
//
//public class UserController {
//    private static final String USERNAME = "xyj";
//    private static final String PASSWORD = "123456";
//
//    /**
//     * 测试登录
//     * @param username
//     * @param password
//     * @return
//     */
//    @RequestMapping("/doLogin")
//    public SaResult doLogin(String username, String password) {
//        //这个方法会强制在浏览器弹出一个认证框
//        SaBasicUtil.check("sa:123456");
//        if(username.equals(USERNAME) && password.equals(PASSWORD)) {
//            //这个是登录用户的主键，业务中你要从数据库中读取
//            StpUtil.login(1);
//            //获取登录生成的token
//            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
//            System.out.println(tokenInfo);
//            return SaResult.ok("登录成功，会话ID为 " + StpUtil.getLoginId() + " ，Token为：" + StpUtil.getTokenValue());
//        }
//        return SaResult.error("登录失败");
//    }
//
//    /**
//     * 查询登录状态
//     * @return
//     */
//    @RequestMapping("/signOut")
//    public SaResult signOut() {
//        String loginId = null;
//        if (StpUtil.isLogin()){
//            loginId = (String) StpUtil.getLoginId();
//            StpUtil.logout();
//        }
//        return SaResult.ok("会话ID为 " + loginId + " 的用户注销登录成功");
//    }
//
//    /**
//     * 查询登录状态
//     * @return
//     */
//    @RequestMapping("/isLogin")
//    public SaResult isLogin() {
//        if (StpUtil.isLogin()){
//            return SaResult.ok("会话是否登录：" + StpUtil.isLogin() + " ，会话ID为 " + StpUtil.getLoginId());
//        }
//        return SaResult.ok("会话是否登录：" + StpUtil.isLogin());
//    }
//
//    /**
//     * 根据Token值获取对应的账号id，如果未登录，则返回 null
//     * @param tokenValue
//     * @return
//     */
//    @RequestMapping("/getUserByToken/{tokenValue}")
//    public SaResult getUserByToken(@PathVariable String tokenValue){
//        return SaResult.ok((String) StpUtil.getLoginIdByToken(tokenValue));
//    }
//
//    /**
//     * 获取当前会话剩余有效期（单位：s，返回-1代表永久有效）
//     * @return
//     */
//    @RequestMapping("/getTokenTimeout")
//    public SaResult getTokenTimeout(){
//        return SaResult.ok(String.valueOf(StpUtil.getTokenTimeout()));
//    }
//
//    @SaIgnore
//    @RequestMapping("/encodePassword")
//    public void encodePassword() throws Exception {
//        /**
//         * md5加盐加密: md5(md5(str) + md5(salt))
//         */
//        String md5 = SaSecureUtil.md5("123456");
//        String md5BySalt = SaSecureUtil.md5BySalt("123456", "salt");
//        System.out.println("MD5加密：" + md5);
//        System.out.println("MD5加盐加密：" + md5BySalt);
//
//        /**
//         * AES对称加密
//         */
//        // 定义秘钥和明文
//        String key = "123456";
//        String text = "这是一个明文用于测试AES对称加密";
//        // 加密
//        String ciphertext = SaSecureUtil.aesEncrypt(key, text);
//        System.out.println("AES加密后：" + ciphertext);
//        // 解密
//        String text2 = SaSecureUtil.aesDecrypt(key, ciphertext);
//        System.out.println("AES解密后：" + text2);
//
//        /**
//         * RSA非对称加密
//         */
//        // 定义私钥和公钥
//        HashMap<String, String> keyMap = SaSecureUtil.rsaGenerateKeyPair();
//        String privateKey = keyMap.get("private");
//        String publicKey = keyMap.get("public");
//        // 文本
//        String text1 = "这是一个明文用于测试RSA非对称加密";
//        // 使用公钥加密
//        String ciphertext1 = SaSecureUtil.rsaEncryptByPublic(publicKey, text1);
//        System.out.println("公钥加密后：" + ciphertext1);
//        // 使用私钥解密
//        String text3 = SaSecureUtil.rsaDecryptByPrivate(privateKey, ciphertext1);
//        System.out.println("私钥解密后：" + text3);
//
//        /**
//         * Base64
//         */
//        // 文本
//        String text4 = "这是一个明文用于测试Base64";
//        // 使用Base64编码
//        String base64Text = SaBase64Util.encode(text4);
//        System.out.println("Base64编码后：" + base64Text);
//        // 使用Base64解码
//        String text5 = SaBase64Util.decode(base64Text);
//        System.out.println("Base64解码后：" + text5);
//
//    }
//}
