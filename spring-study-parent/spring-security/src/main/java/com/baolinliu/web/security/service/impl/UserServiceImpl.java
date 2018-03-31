package com.baolinliu.web.security.service.impl;


import com.baolinliu.web.dto.WebUser;
import com.baolinliu.web.security.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by richey on 17-5-29.
 */
@Service
public class UserServiceImpl implements UserService {


    @Override
    public WebUser getUserByUserNameAndPsd(String userName, String password) {
        //TODO 根据用户名密码查询  密码加盐匹配
        WebUser user = new WebUser();
        user.setUserName("richey");
        user.setPassword("111111");
        if ("richey".equals(userName) && "111111".equals("111111")) {
            return user;
        }else{
            return null;
        }
    }
}
