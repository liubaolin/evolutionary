package com.baolinliu.jdbcData.dao.impl;

import com.baolinliu.jdbcData.dao.StudentDAO;
import com.baolinliu.jdbcData.domain.Student;
import com.baolinliu.jdbcData.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Richey on 2017/6/11.
 */
public class StudentDAOImpl implements StudentDAO {

    @Override
    public List<Student> query() {
        String sql = "SELECT id,name,age FROM student";
        List<Student> students = new ArrayList<Student>();

        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
        try {
            preStatement = connection.prepareStatement(sql);
            resultSet = preStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                students.add(new Student(id,name,age));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.releaseConn(resultSet,preStatement,connection);
        }
        return students;
    }

    @Override
    public void save(Student student) {
        String sql = "INSERT  INTO student(name,age) VALUES(?,?) ";
        List<Student> students = new ArrayList<Student>();

        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
        try {
            preStatement = connection.prepareStatement(sql);
            preStatement.setString(1,student.getName());
            preStatement.setInt(2, student.getAge());
            preStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.releaseConn(resultSet,preStatement,connection);
        }
    }
}
