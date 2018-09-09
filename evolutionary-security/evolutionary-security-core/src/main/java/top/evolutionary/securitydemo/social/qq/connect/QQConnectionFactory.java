package top.evolutionary.securitydemo.social.qq.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import top.evolutionary.securitydemo.social.qq.api.QQApi;

/**
 * @author richey
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQApi> {

    /**
     * @param providerId 提供商唯一标识,例如ＱＱ／ＷＥＩＣＨＡＡＴ
     * @param appId
     * @param appSecret
     */
    public QQConnectionFactory(String providerId, String appId, String appSecret) {
        super(providerId, new QQServiceProvider(appId, appSecret), new QQApiAdapter());
    }
}
