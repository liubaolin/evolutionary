package top.evolutionary.securitydemo.properties;

import top.evolutionary.securitydemo.common.LoginInType;

public class BrowerProperties {

    private String loginPage = "/evolutionary-loginIn.html";//默认跳转

    private String signUpUrl = "/evolutionary-signUp.html";

    private LoginInType loginInType = LoginInType.JSON;

    private int rememberSeconds = 3600;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginInType getLoginInType() {
        return loginInType;
    }

    public void setLoginInType(LoginInType loginInType) {
        this.loginInType = loginInType;
    }

    public int getRememberSeconds() {
        return rememberSeconds;
    }

    public void setRememberSeconds(int rememberSeconds) {
        this.rememberSeconds = rememberSeconds;
    }

    public String getSignUpUrl() {
        return signUpUrl;
    }

    public void setSignUpUrl(String signUpUrl) {
        this.signUpUrl = signUpUrl;
    }
}
