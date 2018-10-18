//package com.email;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.MailException;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.mail.javamail.MimeMessagePreparator;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.io.UnsupportedEncodingException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by harry on 2017/3/21.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
//public class EmailTest {
//    @Autowired
//    JavaMailSender javaMailSender;
//
//    @Test
//    public void sendEmail() {
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        try {
//            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
//            mimeMessageHelper.setFrom("zh_harry@163.com", "harry");
//            mimeMessageHelper.setSubject("出问题了，需要排查");
//            mimeMessageHelper.setText("你好，有问题了！！！", true);
//            List<String> tos = new ArrayList<String>();
//            //tos.add("zlz46216@ly.com");
//            tos.add("492006183@qq.com");
//            for (String to : tos) {
//                if (to != null) {
//                    mimeMessageHelper.setTo(to);
//                    try {
//                        javaMailSender.send(mimeMessageHelper.getMimeMessage());
//                    } catch (MailException e) {
//                        e.printStackTrace();
//                        System.out.printf("send to [" + to + "] failed.", e);
//                    }
//                }
//            }
//        } catch (MessagingException me) {
//            System.out.printf("send" + me);
//        } catch (UnsupportedEncodingException me) {
//            System.out.printf("send" + me);
//        }
//    }
//}
