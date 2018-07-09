package top.evolutionary.securitydemo.validate.code.image;

import top.evolutionary.securitydemo.common.ValidCode;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @author richey
 * 验证码
 */
public class ImageCode extends ValidCode {

    private BufferedImage image;



    public ImageCode() {
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        super(code, expireTime);
        this.image = image;
    }

    /**
     * @param image
     * @param code
     * @param expireIn 秒数，在x秒后过期
     */
    public ImageCode(BufferedImage image, String code, int expireIn) {
        super(code, expireIn);
        this.image = image;

    }


    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

}
