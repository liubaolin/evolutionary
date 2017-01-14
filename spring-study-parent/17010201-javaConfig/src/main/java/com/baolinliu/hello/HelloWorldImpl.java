package com.baolinliu.hello;

/**
 * Created by richey on 16-12-18.
 */
public class HelloWorldImpl implements HelloWorld{
    @Override
    public void sayHello(String str) {
        System.out.println("Hello "+str);
    }
}
