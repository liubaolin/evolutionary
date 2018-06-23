package com.baolinliu.springData.repository;

import com.baolinliu.springDataJpa.domain.Company;
import com.baolinliu.springDataJpa.domain.Customer;
import com.baolinliu.springDataJpa.repository.CustomerSpecificationExecutorRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

/**
 * Created by Richey on 2017/6/15.
 */
public class CustomerSpecificationExecutorRepositoryTest {

    private ApplicationContext ctx = null;
    private CustomerSpecificationExecutorRepository customerSpecificationExecutorRepository = null;

    @Before
    public void setUp() {
        System.out.println("setUp");
        ctx = new ClassPathXmlApplicationContext("spring-data.xml");
        customerSpecificationExecutorRepository = ctx.getBean(CustomerSpecificationExecutorRepository.class);
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
        ctx = null;
    }

    /**
     * 1)分页
     * 2）排序
     * 3）查询条件
     */
    @Test
    public void testQuery() {
        Sort.Order order = new Sort.Order(Sort.Direction.ASC, "id");
        Sort sort = new Sort(order);
        Pageable pageable = new PageRequest(0,5,sort);

        /**
         * root 就是我们要查询的类型（Customer）
         * query：添加查询条件
         * cb：构建Predicate
         */
        Specification<Customer> specification = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                //root (customer(age))
                Path path = root.get("age");
                return cb.gt(path, 50);
            }
        };
        Page<Customer> page = customerSpecificationExecutorRepository.findAll(specification, pageable);
        System.out.println("总共有多少页:"+page.getTotalPages());
        System.out.println("总共有多少条记录:"+page.getTotalElements());
        System.out.println("查询的当前第几页:"+page.getNumber()+1);
        System.out.println("查询的当前页面的集合:"+page.getContent());
        System.out.println("当前页面的记录数:" + page.getNumberOfElements());
    }


    @Test
    public void testQuery2() {
        //混合条件查询
        Specification<Customer> specification = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                Path<String> exp1 = root.get("name");
                Path<Integer> exp2 = root.get("age");
                Predicate predicate = cb.and(cb.like(exp1, "richey"), cb.lessThan(exp2, 30));
                return predicate;
            }
        };

        //多表查询
        Specification<Customer> specification2 = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Join<Customer, Company> join = root.join("company", JoinType.INNER);
                Path<String> exp1 = join.get("name");
                return cb.like(exp1, "richey");
            }
        };

        customerSpecificationExecutorRepository.findAll(specification2);

    }

}
