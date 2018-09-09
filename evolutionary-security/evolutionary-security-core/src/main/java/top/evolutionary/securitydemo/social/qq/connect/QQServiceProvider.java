package top.evolutionary.securitydemo.social.qq.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import top.evolutionary.securitydemo.social.qq.api.QQApi;
import top.evolutionary.securitydemo.social.qq.api.QQApiImpl;

/**
 * SpringSocial将与服务商的交互封装进了ServiceProvider，并提供了抽象的实现AbstractOAutrh2ServiceProvider；
 *
 * @author richey
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQApi> {

    private String appId;

    /**
     * 认证服务器地址（即引导用户跳转的地址，认证服务器会返回授权码）
     */
    private static final String AUTHORIZE_URL = "https://graph.qq.com/oauth2.0/authorize";

    /**
     * 获取token
     */
    private static final String ACCEEE_TOKEN_URL = "https://graph.qq.com/oauth2.0/token";


    /**
     * @param appId     从配置中读取的属性，由第三方服务提供
     * @param appSecret 　从配置中读取的属性，由第三方服务提供
     */
    public QQServiceProvider(String appId, String appSecret) {
        super(new QQOAuth2Template(appId, appSecret, AUTHORIZE_URL, ACCEEE_TOKEN_URL));
        this.appId = appId;
    }

    @Override
    public QQApi getApi(String accessToken) {
        return new QQApiImpl(accessToken, appId);
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
