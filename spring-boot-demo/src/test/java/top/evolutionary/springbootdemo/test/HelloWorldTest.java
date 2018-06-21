package top.evolutionary.springbootdemo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.evolutionary.springbootdemo.SpringBootDemoApplication;
import top.evolutionary.springbootdemo.service.HelloWorldService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootDemoApplication.class)
public class HelloWorldTest {

    @Autowired
    private HelloWorldService helloWorldService;

    @Test
    public void testSayHello() {
        Assert.assertEquals(helloWorldService.sayHello(), "Hello World!");
    }

}
