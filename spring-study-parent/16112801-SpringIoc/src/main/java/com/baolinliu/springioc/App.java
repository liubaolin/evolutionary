package com.baolinliu.springioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by richey on 16-12-18.
 */
public class App {
    public static void main(String[] args) {
        //1.读取配置文件实例化一个IoC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.从容器中获取Bean
        MoAttack1 moAttack1 = (MoAttack1) context.getBean("moAttack");
        //3.执行业务逻辑
        moAttack1.cityGataAsk();
    }
}
