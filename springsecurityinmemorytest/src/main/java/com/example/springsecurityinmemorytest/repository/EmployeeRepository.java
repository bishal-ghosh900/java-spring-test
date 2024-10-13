package com.example.springsecurityinmemorytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springsecurityinmemorytest.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{}
