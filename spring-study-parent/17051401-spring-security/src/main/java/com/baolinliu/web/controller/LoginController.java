package com.baolinliu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by richey on 17-5-20.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

}
