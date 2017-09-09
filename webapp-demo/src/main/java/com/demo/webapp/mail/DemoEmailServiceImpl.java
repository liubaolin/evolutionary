package com.demo.webapp.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * DESCRIPTION: 邮件发送的服务类
 *
 * @author richey
 */
public class DemoEmailServiceImpl {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    public void sendSimpleEmail(String from, String to, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setText(content);
        javaMailSender.send(message);
    }

}
