package top.evolutionary.securitydemo.social.qq.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import java.io.IOException;

/**
 * 由于不同的服务商提供的数据格式不一样，SpringSocial提供了一个接口，以及抽象的类AbstractOAuth2ApiBinding，方便我们继承完善
 *
 * @author richey
 */
public class QQApiImpl extends AbstractOAuth2ApiBinding implements QQApi {

    Logger logger = LoggerFactory.getLogger(getClass());

    private String appId;

    private String openId;

    /**
     * 获取用户信息的请求地址
     */
    private static final String GET_USER_INFO_URL = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";
    /**
     * 获取openId的请求地址
     */
    private static final String GET_OPENID_URL = "https://graph.qq.com/oauth2.0/me?access_token=%s";

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * @param accessToken 从OAuth2认证服务器拿到的令牌，这里需要传就进来
     * @param appId       　这个是配置信息中取的
     */
    public QQApiImpl(String accessToken, String appId) {
        /**
         * accessToken交给父类处理,TokenStrategy.ACCESS_TOKEN_PARAMETER表明在使用restTemplate发送请求的时候，
         * access_token会被当作参数传递进去，不需要我们自己维护　
         */
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        this.appId = appId;
        String url = String.format(GET_OPENID_URL, accessToken);
        String result = getRestTemplate().getForObject(url, String.class);
        this.openId = StringUtils.substringBetween(result, "\"openid\":\"", "\"}");
        logger.info("调用QQ服务获取的openId是:{}", openId);
    }

    @Override
    public QQUserInfo getUserInfo() {
        String url = String.format(GET_USER_INFO_URL, appId, openId);
        String result = getRestTemplate().getForObject(url, String.class);
        logger.info("获取qq用户信息：{}", result);

        try {
            QQUserInfo userInfo = objectMapper.readValue(result, QQUserInfo.class);
            userInfo.setOpenId(openId);
            return userInfo;
        } catch (IOException e) {
            throw new RuntimeException("获取用户信息失败", e);
        }
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
