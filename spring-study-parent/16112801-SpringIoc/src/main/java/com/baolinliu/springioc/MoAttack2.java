package com.baolinliu.springioc;

/**
 * Created by richey on 16-12-18.
 * SpringIoc类型2--构造器注入
 */
public class MoAttack2 {
    private Geli geli;

    public MoAttack2(Geli geli){
        this.geli = geli;
    }

    public void cityGataAsk(){
        geli.responseAsk();
    }
}
