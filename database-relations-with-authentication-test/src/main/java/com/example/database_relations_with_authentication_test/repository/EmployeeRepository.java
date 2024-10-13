package com.example.database_relations_with_authentication_test.repository;

import com.example.database_relations_with_authentication_test.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}
