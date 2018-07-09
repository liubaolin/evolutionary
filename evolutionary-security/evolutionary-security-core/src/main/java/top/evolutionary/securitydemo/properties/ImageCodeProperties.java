package top.evolutionary.securitydemo.properties;

/**
 * 从CodeProperties中继承了length属性，但是由于我们这里验证码用的是GoogleKapchaProperties，所以这里length属性暂时是没有用到的
 */
public class ImageCodeProperties extends CodeProperties {

    public ImageCodeProperties() {
        super.setUrl("/authentication/form");
    }

}
