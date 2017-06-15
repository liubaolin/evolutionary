package com.baolinliu.springData.service;

import com.baolinliu.springDataJpa.repository.CustomerRepository;
import com.baolinliu.springDataJpa.service.CustomerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Richey on 2017/6/14.
 */
public class CustomerServiceTest{

        private ApplicationContext ctx = null;
        private CustomerService customerService = null;

        @Before
        public void setUp() {
            System.out.println("setUp");
            ctx = new ClassPathXmlApplicationContext("spring-data.xml");
            customerService = ctx.getBean(CustomerService.class);
        }

        @After
        public void tearDown() {
            System.out.println("tearDown");
            ctx = null;
        }

    @Test
    public void testUpdate() {
        customerService.update(1L,16);
    }

}
