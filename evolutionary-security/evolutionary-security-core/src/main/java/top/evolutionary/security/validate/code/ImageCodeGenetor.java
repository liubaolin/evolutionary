package top.evolutionary.security.validate.code;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.web.context.request.ServletWebRequest;
import top.evolutionary.security.properties.SecurityProperties;

public class ImageCodeGenetor implements ValidateCodeGenerator {

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
