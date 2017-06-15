package com.baolinliu.jdbcTemplateData.impl;

import com.baolinliu.jdbcData.dao.StudentDAO;
import com.baolinliu.jdbcData.dao.impl.StudentDAOImpl;
import com.baolinliu.jdbcData.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.List;


/**
 * Created by Richey on 2017/6/11.
 */
public class JdbcTemplateDaoImplTest {


    private ApplicationContext ctx = null;
    private StudentDAO studentDAO = null;

    @Before
    public void setUp() {
        System.out.println("setUp");
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentDAO = (StudentDAO) ctx.getBean("studentDao");
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
        ctx = null;
    }


    @Test
    public void queryTest() {
        List<Student> students = studentDAO.query();
        for (Student student : students) {
            System.out.println("Id:" + student.getId() + " name:" + student.getName() + " age:" + student.getAge());
        }
    }

    @Test
    public void saveTest() {
        StudentDAO studentDAO = new StudentDAOImpl();
        Student student = new Student();
        student.setName("jdbcTemplate");
        student.setAge(10);
        studentDAO.save(student);
    }

}