package top.evolutionary.security.properties;

public abstract class CodeProperties {

    protected int width = 4;

    /**
     * 验证码超时时间，单位秒
     */
    protected int expireIn = 60;


    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
