package com.example.database_relations_with_authentication_test.repository;

import com.example.database_relations_with_authentication_test.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {}
