package io.github.Victor5H.dao;

import io.github.Victor5H.entities.Student;

import java.util.List;

public interface StudentDao {
    int insert(Student student);
    int delete(int id);
    int update (Student student);
    Student selectOne(int id);
    List<Student> selectAll();
}
