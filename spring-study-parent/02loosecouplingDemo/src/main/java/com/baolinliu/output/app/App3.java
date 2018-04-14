package com.baolinliu.output.app;

import com.baolinliu.output.helper.SpringOutputHelper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by richey on 16-12-1.
 */
public class App3 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        SpringOutputHelper outputHelper = (SpringOutputHelper) context.getBean("springOutputHelper");
        outputHelper.generateOutput();
    }
}
