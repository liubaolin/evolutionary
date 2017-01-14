package com.baolinliu.annotation.myano;

import java.lang.reflect.Method;

/**
 * Created by richey on 16-11-17.
 * 使用反射方式实现的注解处理器
 */
public class ReflectAnnotationResolver {
    public static void resolverReflectAnnotation(Class<?> clazz){
        for (Method method : clazz.getDeclaredMethods()){
            //getAnnotation方法返回指定类型的Annotation对象,如果没有这返回null
            ReflectAnnotation reflectAnnotation = method.getAnnotation(ReflectAnnotation.class);
            if(reflectAnnotation != null){
                System.out.println("ReflectAnnotation---author:"+reflectAnnotation.auther()+"/nReflectAnnotation---date:"+reflectAnnotation.date());
            }
        }
    }
}
