package com.baolinliu.springData.repository;

import com.baolinliu.springDataJpa.domain.Customer;
import com.baolinliu.springDataJpa.repository.CustomerPagingAndSortingRepository;
import com.baolinliu.springDataJpa.service.CustomerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Richey on 2017/6/15.
 */
public class CustomerPagingAndSortRepositoryTest {

    private ApplicationContext ctx = null;
    private CustomerPagingAndSortingRepository customerPagingAndSortingRepository = null;

    @Before
    public void setUp() {
        System.out.println("setUp");
        ctx = new ClassPathXmlApplicationContext("spring-data.xml");
        customerPagingAndSortingRepository = ctx.getBean(CustomerPagingAndSortingRepository.class);
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
        ctx = null;
    }

    @Test
    public void testPage() {
        //page:index是从0开始的
        Pageable pageable = new PageRequest(0,5);
        Page<Customer> page = customerPagingAndSortingRepository.findAll(pageable);
        System.out.println("总共有多少页:"+page.getTotalPages());
        System.out.println("总共有多少条记录:"+page.getTotalElements());
        System.out.println("查询的当前第几页:"+page.getNumber()+1);
        System.out.println("查询的当前页面的集合:"+page.getContent());
        System.out.println("当前页面的记录数:" + page.getNumberOfElements());
    }

    @Test
    public void tesSort() {

        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = new Sort(order);

        Pageable pageable = new PageRequest(0,5,sort);
        Page<Customer> page = customerPagingAndSortingRepository.findAll(pageable);
        System.out.println("总共有多少页:"+page.getTotalPages());
        System.out.println("总共有多少条记录:"+page.getTotalElements());
        System.out.println("查询的当前第几页:"+page.getNumber()+1);
        System.out.println("查询的当前页面的集合:"+page.getContent());
        System.out.println("当前页面的记录数:" + page.getNumberOfElements());
    }
}
