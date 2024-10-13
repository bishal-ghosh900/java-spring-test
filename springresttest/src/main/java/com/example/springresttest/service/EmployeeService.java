package com.example.springresttest.service;

import com.example.springresttest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee create(Employee employee);
    Employee update(Employee employee);
    String deleteById(int id);
}
