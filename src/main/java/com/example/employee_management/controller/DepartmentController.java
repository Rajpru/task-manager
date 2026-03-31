package com.example.employee_management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_management.entity.Department;
import com.example.employee_management.object.DepartmentDTO;
import com.example.employee_management.response.ApiResponse;
import com.example.employee_management.service.DepartmentService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/department")
@Tag(name="department API", description = "Department operations")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@GetMapping
	public ResponseEntity<ApiResponse<List<Department>>> getDepartments() {
		return ResponseEntity.ok(new ApiResponse<>(true, "Departments fetched",departmentService.getDepartments()));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<Optional<Department>>> getDepartmentById(@PathVariable Long id) {
		return ResponseEntity.ok(new ApiResponse<>(true, "Department fetched", departmentService.getDepartmentById(id)));
	}
	
	@PostMapping
	public ResponseEntity<ApiResponse<Department>> saveDepartment(@RequestBody Department department) {
		return ResponseEntity.ok(new ApiResponse<>(true, "Depsrtment Saved", departmentService.saveDepartment(department)));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<Department>> updatedDepartment(@PathVariable Long id, @RequestBody Department department) {
		return ResponseEntity.ok(new ApiResponse<>(true, "Department Updated", departmentService.updatedDepartment(id,department)));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<String>> deleteDepartment(@PathVariable Long id) {
		return ResponseEntity.ok(new ApiResponse<>(true, "Department is deleted", departmentService.deleteDepartment(id)));
	}
}
