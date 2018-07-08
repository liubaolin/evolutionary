package top.evolutionary.security.properties;

/**
 * 从CodeProperties中继承了width属性，但是由于我们这里验证码用的是GoogleKapchaProperties，所以这里width属性暂时是没有用到的
 */
public class ImageCodeProperties extends CodeProperties {


    /**
     * 默认拦截的需要校验验证码的url
     */
    private String url = "/authentication/form";


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
