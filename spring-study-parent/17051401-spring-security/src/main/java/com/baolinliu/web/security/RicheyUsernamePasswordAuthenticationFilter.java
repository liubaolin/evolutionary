package com.baolinliu.web.security;

import com.alibaba.fastjson.JSON;
import com.baolinliu.web.dto.WebUser;
import com.baolinliu.web.security.service.UserService;
import com.baolinliu.web.security.vo.LoginRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by richey on 17-5-26.
 */
public class RicheyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

    private static final String USER_NAME = "userName";
    private static final String PASSWORD = "password";

    @Autowired
    private UserService userService;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        //POST请求验证

        //TODO 认证逻辑
        //处理请求信息
        LoginRequestVO loginRequestVO =  getLoginRequestVO(request);

        WebUser user = userService.getUserByUserNameAndPsd(loginRequestVO.getUserName(), loginRequestVO.getPassword());
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        setDetails(request, authRequest);
        return super.attemptAuthentication(request, response);
    }


    /**
     * 获取登录请求VO对象
     * @param request
     * @return
     */
    private LoginRequestVO getLoginRequestVO(HttpServletRequest request) {
        LoginRequestVO loginRequestVO =  new LoginRequestVO();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String str = null;
            while ((str = reader.readLine()) != null) {
                sb.append(str);
            }
            if (!StringUtils.isEmpty(str)) {
                loginRequestVO = (LoginRequestVO) JSON.parse(sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //TODO 校验处理LoginrequestVO

        return loginRequestVO;
    }
}
