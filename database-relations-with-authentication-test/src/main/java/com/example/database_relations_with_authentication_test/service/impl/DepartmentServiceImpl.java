package com.example.database_relations_with_authentication_test.service.impl;

import com.example.database_relations_with_authentication_test.entity.Department;
import com.example.database_relations_with_authentication_test.repository.DepartmentRepository;
import com.example.database_relations_with_authentication_test.service.DepartmentService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findDepartmentById(int id) {

        Optional<Department> department = departmentRepository.findById(id);

        if(department.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Department not found");
        }

        return department.get();
    }
}
