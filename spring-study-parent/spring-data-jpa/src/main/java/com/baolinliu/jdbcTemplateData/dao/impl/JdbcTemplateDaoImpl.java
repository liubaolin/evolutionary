package com.baolinliu.jdbcTemplateData.dao.impl;

import com.baolinliu.jdbcData.dao.StudentDAO;
import com.baolinliu.jdbcData.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Richey on 2017/6/11.
 */
public class JdbcTemplateDaoImpl implements StudentDAO{

    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Student> query() {
        final List<Student> students = new ArrayList<Student>();
        String sql = "SELECT id,name,age FROM student";
        jdbcTemplate.query(sql, new RowCallbackHandler(){
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                students.add(new Student(id,name,age));
            }
        });
        return students;
    }

    @Override
    public void save(Student student) {
        String sql = "INSERT  INTO student(name,age) VALUES(?,?) ";
        jdbcTemplate.update(sql,new Object[]{student.getName(),student.getAge()});
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
