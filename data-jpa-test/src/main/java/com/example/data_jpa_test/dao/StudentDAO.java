package com.example.data_jpa_test.dao;

import com.example.data_jpa_test.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(int id);
    List<Student> findAllStudent();
    Student findStudentByName(String name);
}
