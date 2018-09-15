package top.evolutionary.springbootdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.evolutionary.springbootdemo.service.ServiceA;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootDemoApplication.class)
public class TransactionTest {

    Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private ServiceA serviceA;


    @Test
    public void testServiceA() throws InterruptedException {
        Thread.currentThread().setName("thread-test");
        logger.info("methodA1执行，当前线程是：{}", Thread.currentThread().getName());
        serviceA.methodA1();
    }

}
