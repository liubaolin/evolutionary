package com.baolinliu.config;
import com.baolinliu.hello.HelloWorld;
import com.baolinliu.hello.HelloWorldImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by richey on 16-12-18.
 *
 */
@Configuration
public class AppConfig {

    @Bean(name = "helloworld")
    public HelloWorld helloWorld(){
        return new HelloWorldImpl();
    }

}
