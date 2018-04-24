package top.evolutionary.security.dto;

import com.fasterxml.jackson.annotation.JsonView;

public class User {

    public interface UserSimpleView {};

    public interface UserDetailView extends UserSimpleView { };

    private String userName;
    private String password;

    @JsonView(UserSimpleView.class)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
