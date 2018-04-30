package top.evolutionary.security.properties;

public class BrowerProperties {

    //配置登录页
    private String loginPage = "/evolutionary-loginIn.html";

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
