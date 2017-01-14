package com.baolinliu;

import com.baolinliu.config.AppConfig;
import com.baolinliu.hello.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!o
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld hello = (HelloWorld) context.getBean("helloworld");
        hello.sayHello("richey");
    }
}
