package com.baolinliu.springevent;

import org.springframework.context.ApplicationListener;

/**
 * Created by richey on 17-1-3.
 */
public class MailSendListener implements ApplicationListener<MailSendEvent> {
    public void onApplicationEvent(MailSendEvent event) {
        System.out.println("MailSendListener:向"+event.getTo()+"发送一封邮件");
    }
}
