package top.evolutionary.springbootdemo.service.impl;

import org.springframework.stereotype.Service;
import top.evolutionary.springbootdemo.service.HelloWorldService;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {


    @Override
    public String sayHello() {
        return "Hello World!";
    }
}
