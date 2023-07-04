//package com.qing.api.util;
//
//
//import com.qing.api.vo.mail.SendEmailVo;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.MailException;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//
///**
// * @author libarAdministrator
// */
//@Component
//public class EmailUtil {
//
//    @Value("${spring.mail.username}")
//    private String fromEmail;
//
//    @Resource
//    private JavaMailSenderImpl mailSender;
//
//
//    public boolean sendEmail(SendEmailVo sendEmailVo){
//        //创建简单邮件消息
//        SimpleMailMessage message = new SimpleMailMessage();
//        //谁发的
//        message.setFrom(fromEmail);
//        //谁要接收
//        message.setTo(sendEmailVo.getTos());
//        //邮件标题
//        message.setSubject(sendEmailVo.getSubject());
//        //邮件内容
//        message.setText(sendEmailVo.getContent());
//        try {
//            mailSender.send(message);
//            return true;
//        } catch (MailException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//
//
//
//}
