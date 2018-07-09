package top.evolutionary.securitydemo.social.qq.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import top.evolutionary.securitydemo.social.qq.api.QQ;

/**
 * @author richey
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

    public QQConnectionFactory(String providerId, String appId, String appSecret) {
        super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
    }
}
