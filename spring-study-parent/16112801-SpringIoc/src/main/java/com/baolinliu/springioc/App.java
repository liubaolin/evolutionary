package com.baolinliu.springioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by richey on 16-12-18.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationCextext.xml");
        MoAttack1 moAttack1 = (MoAttack1) context.getBean("moAttack");
        moAttack1.cityGataAsk();
    }
}
