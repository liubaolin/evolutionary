package top.evolutionary.securitydemo;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import top.evolutionary.securitydemo.properties.GoogleKapchaProperties;
import top.evolutionary.securitydemo.properties.SecurityProperties;

/**
 * @author richey
 */
@Configuration
@EnableConfigurationProperties(value = {SecurityProperties.class, GoogleKapchaProperties.class})
public class SecurityCoreConfig {


}
