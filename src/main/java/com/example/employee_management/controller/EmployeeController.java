package com.example.employee_management.controller;

import com.example.employee_management.entity.Employee;
import com.example.employee_management.object.EmployeeDTO;
import com.example.employee_management.response.ApiResponse;
import com.example.employee_management.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
@Tag(name = "Employee API", description = "Employee management operations")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Operation(summary = "Get all employees with pagination")
    @GetMapping
    public ResponseEntity<ApiResponse<Page<Employee>>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Employees fetched",
                        employeeService.getEmployees(page, size))
        );
    }

    @Operation(summary = "Get employee by id")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> getById(@PathVariable long id) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Employee fetched",
                        employeeService.getEmployeeById(id))
        );
    }

    @Operation(summary = "Create employee")
    @PostMapping
    public ResponseEntity<ApiResponse<Employee>> save(
            @Valid @RequestBody EmployeeDTO dto) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Employee created",
                        employeeService.save(dto))
        );
    }

    @Operation(summary = "Update employee")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> update(
            @PathVariable long id,
            @Valid @RequestBody EmployeeDTO dto) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Employee updated",
                        employeeService.updateEmployee(id, dto))
        );
    }

    @Operation(summary = "Delete employee")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable long id) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Employee deleted",
                        employeeService.deleteEmployee(id))
        );
    }
}