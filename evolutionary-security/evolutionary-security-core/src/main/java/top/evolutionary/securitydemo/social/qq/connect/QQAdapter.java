package top.evolutionary.securitydemo.social.qq.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import top.evolutionary.securitydemo.social.qq.api.QQ;
import top.evolutionary.securitydemo.social.qq.api.QQUserInfo;

/**
 * @author richey
 */
public class QQAdapter implements ApiAdapter<QQ> {

    /**
     * 测试我们的接口服务是否可以调通
     *
     * @param api
     * @return
     */
    @Override
    public boolean test(QQ api) {
        return true;
    }

    @Override
    public void setConnectionValues(QQ api, ConnectionValues values) {
        QQUserInfo userInfo = api.getUserInfo();
        values.setDisplayName(userInfo.getNickname());
        values.setImageUrl(userInfo.getFigureurl_qq_1());
        //个人主页地址
        values.setProfileUrl(null);
        //用户在服务商那对应的唯一id
        values.setProviderUserId(userInfo.getOpenId());

    }

    @Override
    public UserProfile fetchUserProfile(QQ api) {
        return null;
    }

    /**
     * 更新数据
     * @param api
     * @param message
     */
    @Override
    public void updateStatus(QQ api, String message) {
        // do nothing
    }
}
