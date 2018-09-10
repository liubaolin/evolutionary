package top.evolutionary.springbootdemo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import top.evolutionary.springbootdemo.service.ServiceA;
import top.evolutionary.springbootdemo.service.ServiceB;

@Service
public class ServiceAImpl implements ServiceA {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ServiceB serviceB;

    @Async
    @Override
    public void methodA1() throws InterruptedException {
        logger.info("methodA1执行，当前线程是：{}", Thread.currentThread().getName());
        serviceB.methodB1();
        logger.info("methodA1执行结束．");
    }

}
