package com.baolinliu.springioc;

/**
 * Created by richey on 16-12-18.
 * SpringIoc类型3--接口注入
 * 本质上同属性注入一样,却要再增加一个接口,不推荐该用法
 */
public class MoAttack3 implements ActorInterface{
    private  Geli geli;

    @Override
    public void injectGeli(Geli geli) {
        this.geli = geli;
    }
}
