package top.evolutionary.securitydemo.social.qq.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;
import top.evolutionary.securitydemo.social.qq.api.QQ;
import top.evolutionary.securitydemo.social.qq.api.QQImpl;

/**
 * @author richey
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

    private String appId;

    /**
     * 获取授权码
     */
    private static final String AUTHORIZE_URL = "https://graph.qq.com/oauth2.0/authorize";

    /**
     * 获取token
     */
    private static final String ACCEEE_TOKEN_URL = "https://graph.qq.com/oauth2.0/token";


    public QQServiceProvider(String appId, String appSecret) {
        super(new OAuth2Template(appId, appSecret, AUTHORIZE_URL, ACCEEE_TOKEN_URL));
    }

    @Override
    public QQ getApi(String accessToken) {
        return new QQImpl(accessToken, appId);
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
