package top.evolutionary.security.properties;

public class ImageCodeProperties {

    /**
     * 图片验证码超时时间，单位秒
     */
    private int expireIn = 60;

    /**
     * 默认拦截的需要校验验证码的url
     */
    private String url = "/authentication/form";

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
