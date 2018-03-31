package com.baolinliu.web.security.service;

import com.baolinliu.web.dto.WebUser;

/**
 * Created by richey on 17-5-29.
 */
public interface UserService {


    WebUser getUserByUserNameAndPsd(String userName, String password);
}
