package top.evolutionary.securitydemo.validate.code.image;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.web.context.request.ServletWebRequest;
import top.evolutionary.securitydemo.properties.SecurityProperties;
import top.evolutionary.securitydemo.validate.code.ValidateCodeGenerator;

/**
 * @author richey
 */
public class ImageValidateCodeGenerator implements ValidateCodeGenerator {

    private DefaultKaptcha captchaProducer = null;

    private SecurityProperties securityProperties;

    @Override
    public ImageCode generate(ServletWebRequest request) {
        String code = captchaProducer.createText();
        return new ImageCode(captchaProducer.createImage(code), code, securityProperties.getCode().getImage().getExpireIn());
    }

    public DefaultKaptcha getCaptchaProducer() {
        return captchaProducer;
    }

    public void setCaptchaProducer(DefaultKaptcha captchaProducer) {
        this.captchaProducer = captchaProducer;
    }

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }
}
