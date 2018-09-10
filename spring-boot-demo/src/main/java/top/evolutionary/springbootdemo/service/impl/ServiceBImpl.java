package top.evolutionary.springbootdemo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import top.evolutionary.springbootdemo.dto.primary.Foo;
import top.evolutionary.springbootdemo.repository.primary.FooRepository;
import top.evolutionary.springbootdemo.service.ServiceB;

import javax.transaction.Transactional;

@Service
public class ServiceBImpl implements ServiceB {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private FooRepository fooRepository;


    @Transactional(rollbackOn = Exception.class)
    @Override
    public void methodB1() throws InterruptedException {

//        Thread.sleep(2000);
        logger.info("methodB1执行，当前线程是：{}", Thread.currentThread().getName());
        logger.info("当前存在事务：" + TransactionSynchronizationManager.isActualTransactionActive());

        Foo foo = new Foo();
        foo.setName("methodB1");
        foo.setAge(1);
        fooRepository.save(foo);

        methodB2();
//        methodB3();
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void methodB2() {
        logger.info("methodB2执行，当前线程是：{}", Thread.currentThread().getName());
        logger.info("当前存在事务：" + TransactionSynchronizationManager.isActualTransactionActive());
        Foo foo = new Foo();
        foo.setName("methodB2");
        foo.setAge(2);

        fooRepository.save(foo);
    }


    private void methodB3() {
        logger.info("methodB3执行，当前线程是：{}", Thread.currentThread().getName());
        logger.info("当前存在事务：" + TransactionSynchronizationManager.isActualTransactionActive());
        Foo foo = new Foo();
        foo.setName("methodB3");
        foo.setAge(3);

        fooRepository.save(foo);
    }


}
