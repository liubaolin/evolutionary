package com.baolinliu.web.security.vo;

/**
 * Created by richey on 17-5-29.
 * 登录请求对象
 */
public class LoginRequestVO {

    private String userName;

    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
