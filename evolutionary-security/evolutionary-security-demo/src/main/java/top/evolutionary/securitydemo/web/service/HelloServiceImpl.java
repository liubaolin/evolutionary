package top.evolutionary.securitydemo.web.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public void greeting(String name) {
        System.out.println("hello " + name);
    }
}
