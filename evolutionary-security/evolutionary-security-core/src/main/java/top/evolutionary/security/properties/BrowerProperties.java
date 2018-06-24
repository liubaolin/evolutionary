package top.evolutionary.security.properties;

public class BrowerProperties {

    private String loginPage = "/evolutionary-loginIn.html";//默认跳转

    private LoginInType loginInType = LoginInType.JSON;

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
}
