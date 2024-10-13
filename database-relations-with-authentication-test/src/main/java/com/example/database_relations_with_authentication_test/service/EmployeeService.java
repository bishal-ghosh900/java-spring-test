package com.example.database_relations_with_authentication_test.service;

import com.example.database_relations_with_authentication_test.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAllEmployees();
    Employee findEmployeeById(int id);

}
