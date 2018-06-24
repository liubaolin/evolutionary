package top.evolutionary.security.validate.code;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @author richey
 * 验证码
 */
public class ImageCode {

    private BufferedImage image;

    private String code;

    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    public ImageCode() {
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        this.image = image;
        this.code = code;
        this.expireTime = expireTime;
    }

    /**
     * @param image
     * @param code
     * @param expireIn 秒数，在x秒后过期
     */
    public ImageCode(BufferedImage image, String code, int expireIn) {
        this.image = image;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }


    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public boolean isExpired() {
        return this.expireTime == null || this.expireTime.isBefore(LocalDateTime.now());
    }
}
