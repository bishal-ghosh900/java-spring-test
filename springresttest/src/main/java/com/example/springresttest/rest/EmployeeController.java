package com.example.springresttest.rest;

import com.example.springresttest.entity.Employee;
import com.example.springresttest.model.SuccessResponse;
import com.example.springresttest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {
        return employeeService.findById(employeeId);
    }

    @PostMapping("employees")
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @PutMapping("employees")
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @DeleteMapping("employees/{employeeId}")
    public ResponseEntity<SuccessResponse> delete(@PathVariable int employeeId) {
        String message = employeeService.deleteById(employeeId);
        SuccessResponse response = new SuccessResponse(
                HttpStatus.OK.value(),
                message,
                System.currentTimeMillis()
        );
        return ResponseEntity.ok(response);
    }
}
