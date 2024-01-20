package com.mdx.hubing.module.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;

import java.io.File;

/**
 * Author: Meng
 * Date: 2023-08-21
 * Desc:
 */
public class EmailHelper {

    @Autowired
    private JavaMailSender javaMailSender;

    @Async("taskExecutor")
    public void senderEmail(String account) {
        //一个复杂的邮件
        MimeMessage message = this.javaMailSender.createMimeMessage();
        try {
            //组装
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            //正文
            //主题
            helper.setSubject("小可爱，欢迎你的到来哦！！！");
            //开启html模式
            helper.setText("<h1>小可爱,我想你一定会喜欢这里吧！！！</h1>" +
                    "<p>你的账号为:"+account+"</p>" +
                    "<p>你的密码为："+account+"</p>", true);
            //附件
            helper.addAttachment("1.jpg", new File("C:\\Users\\ASUS\\Desktop\\杂七杂八\\杂图\\2.gif"));
            helper.setTo(account);
            helper.setFrom("790933839@qq.com");
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
