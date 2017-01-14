package com.baolinliu;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by richey on 16-11-20.
 * 1.基于Spring容器的最简单的Helloworld实例
 * 2.这里spring的配置用的xml文件,下一个demo是用javaConfig配置的
 */
public class SayHello {

    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld helloObj = (HelloWorld) appContext.getBean("helloBean");
        helloObj.printHelloworld();
    }

}
