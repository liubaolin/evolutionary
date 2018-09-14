package top.evolutionary.securitydemo.security;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

/**
 * @author richey
 */
@Component
public class DemoConnectionSignUp implements ConnectionSignUp {
    @Override
    public String execute(Connection<?> connection) {
        //todo 根据社交用户信息默认创建用户并返回用户唯一标识 这里mock一下就返回社交用户的名字
        return connection.getDisplayName();
    }
}
