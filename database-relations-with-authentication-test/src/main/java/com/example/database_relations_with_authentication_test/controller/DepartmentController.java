package com.example.database_relations_with_authentication_test.controller;

import com.example.database_relations_with_authentication_test.entity.Department;
import com.example.database_relations_with_authentication_test.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> getAllEmployees() {
        return departmentService.findAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getEmployeeById(@PathVariable("id") int id) {
        return departmentService.findDepartmentById(id);
    }
}
