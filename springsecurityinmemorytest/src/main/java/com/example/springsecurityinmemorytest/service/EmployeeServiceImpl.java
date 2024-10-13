package com.example.springsecurityinmemorytest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springsecurityinmemorytest.entity.Employee;
import com.example.springsecurityinmemorytest.exception.EmployeeException;
import com.example.springsecurityinmemorytest.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public String deleteEmoployeeById(int id) {
        Employee employee = findEmployeeById(id);

        employeeRepository.delete(employee);

        return "Employee is deleted";
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if(employee.isEmpty()) {
            throw EmployeeException.of("Employee not found");
        }

        return employee.get();
    }

    @Transactional
    @Override
    public Employee updatEmployee(Employee employee) {
        
        if(!employeeRepository.existsById(employee.getId())) {
            throw EmployeeException.of("Employee not found");
        }

        return employeeRepository.save(employee);
    }

}
