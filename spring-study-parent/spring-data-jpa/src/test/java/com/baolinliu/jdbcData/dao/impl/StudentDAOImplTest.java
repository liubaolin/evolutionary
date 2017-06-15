package com.baolinliu.jdbcData.dao.impl;

import com.baolinliu.jdbcData.dao.StudentDAO;
import com.baolinliu.jdbcData.domain.Student;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * Created by Richey on 2017/6/11.
 */
public class StudentDAOImplTest extends TestCase {

    @Test
    public void testQuery() {
        StudentDAO studentDAO = new StudentDAOImpl();
        List<Student> students = studentDAO.query();
        for (Student student : students) {
            System.out.println("Id:" + student.getId() + " name:" + student.getName() + " age:" + student.getAge());
        }
    }

    @Test
    public void testSave() {
        StudentDAO studentDAO = new StudentDAOImpl();
        Student student = new Student();
        student.setName("test");
        student.setAge(6);
        studentDAO.save(student);
    }

}