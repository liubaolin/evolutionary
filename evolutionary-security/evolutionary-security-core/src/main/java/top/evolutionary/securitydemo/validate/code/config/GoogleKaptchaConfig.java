package top.evolutionary.securitydemo.validate.code.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.evolutionary.securitydemo.properties.GoogleKapchaProperties;

import java.util.Properties;

@Configuration
public class GoogleKaptchaConfig {

    @Autowired
    private GoogleKapchaProperties googleKapchaProperties;

    @Bean
    public DefaultKaptcha getDefaultKaptcha() {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.setProperty("kaptcha.border", googleKapchaProperties.getBorder());
        properties.setProperty("kaptcha.border.color", googleKapchaProperties.getBorderColor());
        properties.setProperty("kaptcha.textproducer.font.color", googleKapchaProperties.getTextproducerFontColor());
        properties.setProperty("kaptcha.image.width", googleKapchaProperties.getImageWidth());
        properties.setProperty("kaptcha.image.height", googleKapchaProperties.getImageHeight());
        properties.setProperty("kaptcha.textproducer.font.size", googleKapchaProperties.getTextproducerFontSize());
        properties.setProperty("kaptcha.session.key", googleKapchaProperties.getSessionKey());
        properties.setProperty("kaptcha.textproducer.char.length", googleKapchaProperties.getTextproducerCharLength());
        properties.setProperty("kaptcha.textproducer.font.names", googleKapchaProperties.getTextproducerFontName());
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }

}
