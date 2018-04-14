package com.baolinliu.springioc;

/**
 * Created by richey on 16-12-18.
 * 电影<<墨攻>>
 * SpringIoc类型1--属性注入
 */
public class MoAttack1 {

    private  Geli geli;//属性注入,设计setter方法即可

    public void setGeli(Geli geli) {
        this.geli = geli;
    }

    public void cityGataAsk(){
        geli.responseAsk();
    }
}
