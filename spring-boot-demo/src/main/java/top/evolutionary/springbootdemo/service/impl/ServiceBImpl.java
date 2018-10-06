package top.evolutionary.springbootdemo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import top.evolutionary.springbootdemo.dto.primary.Foo;
import top.evolutionary.springbootdemo.repository.primary.FooRepository;
import top.evolutionary.springbootdemo.service.ServiceB;

import java.util.Date;

@Service
public class ServiceBImpl implements ServiceB {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private FooRepository fooRepository;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void methodB1() throws InterruptedException {
        logger.info("--------methodB1--Start");

//        Thread.sleep(2000);
        logger.info("methodB1执行，当前线程是：{}", Thread.currentThread().getName());
        logger.info("methodB1当前存在事务：" + TransactionSynchronizationManager.isActualTransactionActive());

        Foo foo = new Foo();
        foo.setName("methodB1");
        foo.setAge(1);
        foo.setUpdateAt(new Date());
        fooRepository.save(foo);

        ((ServiceB)AopContext.currentProxy()).methodB2();
        logger.info("--------methodB1--End");

//        methodB3();
    }

    @Async
    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void methodB2() {
        logger.info("----methodB2--Start");

        logger.info("methodB2执行，当前线程是：{}", Thread.currentThread().getName());
        logger.info("methodB2当前存在事务：" + TransactionSynchronizationManager.isActualTransactionActive());
        Foo foo = new Foo();
        foo.setName("methodB2");
        foo.setAge(2);
        foo.setUpdateAt(new Date());

        fooRepository.save(foo);
//        throw new RuntimeException("事务异常回滚测试");
        logger.info("----methodB2--End");

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
