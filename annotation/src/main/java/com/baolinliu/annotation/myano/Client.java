package com.baolinliu.annotation.myano;

/**
 * Created by richey on 16-11-17.
 */
public class Client {
    @ReflectAnnotation(auther = "richey",date = "2016-11-18",version = 1)
    public void testAll(){
    }
    //因为date没有给默认值,所以这里必须赋值
    @ReflectAnnotation(date = "2016-11-18")
    public void testDate(){
    }
    public static void main(String[] args) {
        ReflectAnnotationResolver.resolverReflectAnnotation(Client.class);
    }
}
