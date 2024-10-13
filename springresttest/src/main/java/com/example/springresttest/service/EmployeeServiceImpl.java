package com.example.springresttest.service;

import com.example.springresttest.dao.EmployeeRepository;
import com.example.springresttest.entity.Employee;
import com.example.springresttest.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee not found");
        }
        return employee.get();
    }

    @Override
    @Transactional
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public Employee update(Employee employee) {
        findById(employee.getId());
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public String deleteById(int id) {
        findById(id);
        employeeRepository.deleteById(id);
        return "Employee deleted id: " + id;
    }
}
