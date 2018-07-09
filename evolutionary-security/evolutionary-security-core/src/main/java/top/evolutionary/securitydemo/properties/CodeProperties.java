package top.evolutionary.securitydemo.properties;

public abstract class CodeProperties {

    protected int length = 4;

    /**
     * 验证码超时时间，单位秒
     */
    protected int expireIn = 60;

    /**
     * 默认拦截的需要校验验证码的url
     */
    private String url ;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
