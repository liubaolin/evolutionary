package com.baolinliu.springData.repository;

import com.baolinliu.springDataJpa.domain.Customer;
import com.baolinliu.springDataJpa.repository.CustomerJpaRepository;
import com.baolinliu.springDataJpa.service.CustomerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Richey on 2017/6/15.
 */
public class CustomerJpaRepositoryTest {

    private ApplicationContext ctx = null;
    private CustomerJpaRepository customerJpaRepository = null;

    @Before
    public void setUp() {
        System.out.println("setUp");
        ctx = new ClassPathXmlApplicationContext("spring-data.xml");
        customerJpaRepository = ctx.getBean(CustomerJpaRepository.class);
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
        ctx = null;
    }

    @Test
    public void testFind() {
        Customer customer = customerJpaRepository.findOne(18L);
        System.out.println(customer);
    }
}
