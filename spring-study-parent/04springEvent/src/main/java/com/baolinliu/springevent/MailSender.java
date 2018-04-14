package com.baolinliu.springevent;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by richey on 17-1-3.
 */

public class MailSender implements ApplicationContextAware{
    private  ApplicationContext ctx;
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    public void sendMail(String to){
        System.out.println("MailSender:模拟发送邮件...");
        MailSendEvent mse = new MailSendEvent(this.ctx,to);
        ctx.publishEvent(mse);
    }
}
