package com.baolinliu.jdbcData.dao;

import com.baolinliu.jdbcData.domain.Student;

import java.util.List;

/**
 * Created by Richey on 2017/6/11.
 */
public interface StudentDAO {

    /**
     * 查询所有的学生
     * @return
     */
    List<Student> query();

    /**
     * 添加一个学生
     * @param student
     */
    void save(Student student);
}
