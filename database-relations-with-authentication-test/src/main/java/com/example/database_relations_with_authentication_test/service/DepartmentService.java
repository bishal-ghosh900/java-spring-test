package com.example.database_relations_with_authentication_test.service;

import com.example.database_relations_with_authentication_test.entity.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> findAllDepartments();
    Department findDepartmentById(int id);
}
