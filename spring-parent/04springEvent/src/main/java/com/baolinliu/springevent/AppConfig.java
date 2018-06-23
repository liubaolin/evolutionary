package com.baolinliu.springevent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by richey on 17-1-3.
 */
@Configuration
public class AppConfig {

    @Bean(name = "mailSender")
    public MailSender mailSender(){
        return new MailSender();
    }

    @Bean(name = "mailSendListener")
    public MailSendListener mailSendListener(){
        return new MailSendListener();
    }
}
