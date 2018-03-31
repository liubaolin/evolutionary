package com.baolinliu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("demo")
public class DemoController {

    @RequestMapping(path = "/hello",method = RequestMethod.GET)
    public void sayHello() {
        System.out.println("hello Controller");
    }

    @RequestMapping(path = "/map/{key1}/{key2}",method = RequestMethod.GET)
    public void testMapPathUri(@PathVariable Map<String,String> mapuri) {
        String key = mapuri.keySet().iterator().next();
        System.out.println(key);
        System.out.println(mapuri.get(key));
    }

}
