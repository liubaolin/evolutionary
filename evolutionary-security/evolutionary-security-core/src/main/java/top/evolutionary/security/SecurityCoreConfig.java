package top.evolutionary.security;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import top.evolutionary.security.properties.GoogleKapchaProperties;
import top.evolutionary.security.properties.SecurityProperties;

@Configuration
@EnableConfigurationProperties(value = {SecurityProperties.class, GoogleKapchaProperties.class})
public class SecurityCoreConfig {


}
