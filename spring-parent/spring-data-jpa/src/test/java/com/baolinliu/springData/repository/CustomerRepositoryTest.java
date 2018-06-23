package com.baolinliu.springData.repository;

import com.baolinliu.springDataJpa.domain.Customer;
import com.baolinliu.springDataJpa.domain.CustomerVO;
import com.baolinliu.springDataJpa.repository.CustomerRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Richey on 2017/6/14.
 */
public class CustomerRepositoryTest {

    private ApplicationContext ctx = null;
    private CustomerRepository customerRepository = null;

    @Before
    public void setUp() {
        System.out.println("setUp");
        ctx = new ClassPathXmlApplicationContext("spring-data.xml");
        customerRepository = ctx.getBean(CustomerRepository.class);
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
        ctx = null;
    }

    @Test
    public void testFindByName() {
        Customer customer = customerRepository.findByName("richey");
        System.out.println("id:" + customer.getId() + " name:" + customer.getName());
    }

    @Test
    public void testLike() {
        List<Customer> customers = customerRepository.queryList1("ch");
        for (Customer customer : customers) {
            System.out.println("id:" + customer.getId() + " name:" + customer.getName());
        }
    }

    @Test
    public void testNativeCount() {
        long count = customerRepository.getCount();
        System.out.println(count);
    }

    @Test
    public void testNative() {
        List<Customer> customers = customerRepository.getNativeCustomer();
        for (Customer customer : customers) {
            System.out.println("id:" + customer.getId() + " name:" + customer.getName());
        }
    }

    @Test
    public void testNative2() {
        List<Object[]> customers = customerRepository.getNativeCustomer2();
        for (Object[] obj : customers) {
            System.out.println("id:" + obj[0] + " name:" + obj[1]);
        }
    }





}
