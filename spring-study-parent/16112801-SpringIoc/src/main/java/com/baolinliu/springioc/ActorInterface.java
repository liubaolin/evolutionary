package com.baolinliu.springioc;

/**
 * Created by richey on 16-12-18.
 * 将所有要注入的方法抽象到一个接口中
 */
public interface ActorInterface {
    void injectGeli(Geli geli);
}
