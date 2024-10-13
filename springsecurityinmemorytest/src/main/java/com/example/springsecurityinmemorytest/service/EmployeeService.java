package com.example.springsecurityinmemorytest.service;

import java.util.List;

import com.example.springsecurityinmemorytest.entity.Employee;


public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findEmployeeById(int id);
    public Employee addEmployee(Employee employee);
    public String deleteEmoployeeById(int id);
    public Employee updatEmployee(Employee employee);
}
