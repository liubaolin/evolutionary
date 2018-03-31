package com.baolinliu.web.dto;

/**
 * Created by richey on 17-5-29.
 * web用户信息
 */
public class WebUser {

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
