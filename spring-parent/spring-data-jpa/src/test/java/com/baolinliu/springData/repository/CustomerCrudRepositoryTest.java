package com.baolinliu.springData.repository;

import com.baolinliu.springDataJpa.domain.Customer;
import com.baolinliu.springDataJpa.repository.CustomerRepository;
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
public class CustomerCrudRepositoryTest {

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
    public void testSaveCustomers() {
        List<Customer> customers = new ArrayList<Customer>();
      for(int i=0;i<100;i++) {
          Customer customer = new Customer();
          customer.setName("richey" + i);
          customer.setAge(1 + i);
          customers.add(customer);
      }
        customerService.saveCustomers(customers);
    }

}
