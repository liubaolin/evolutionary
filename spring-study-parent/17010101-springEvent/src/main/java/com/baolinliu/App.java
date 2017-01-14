package com.baolinliu;

import com.baolinliu.springevent.AppConfig;
import com.baolinliu.springevent.MailSender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MailSender mailSender = (MailSender) context.getBean("mailSender");
        mailSender.sendMail("baolin1991@126.com");
    }
}
