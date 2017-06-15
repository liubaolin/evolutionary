package com.baolinliu.springData;

import com.baolinliu.jdbcData.dao.StudentDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Richey on 2017/6/12.
 */
public class SpringDataTest {

    private ApplicationContext ctx = null;
    private StudentDAO studentDAO = null;

    @Before
    public void setUp() {
        System.out.println("setUp");
        ctx = new ClassPathXmlApplicationContext("spring-data.xml");
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
        ctx = null;
    }

    @Test
    public void entityManagerFactory() {

    }


}
