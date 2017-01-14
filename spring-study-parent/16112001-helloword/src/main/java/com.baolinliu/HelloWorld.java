package com.baolinliu;

/**
 * Created by richey on 16-11-20.
 */
public class HelloWorld {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printHelloworld(){
        System.out.println("spring4:hello "+name);
    }
}
