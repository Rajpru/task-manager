package com.example.employee_management.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee_management.entity.Department;
import com.example.employee_management.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;
	
	public List<Department> getDepartments() {
		return departmentRepository.findAll();
	}

	public Optional<Department> getDepartmentById(Long id) {
		return departmentRepository.findById(id);
	}

	public Department saveDepartment(Department department) {
		department.setCreatedAt(new Date());
		return departmentRepository.save(department);
	}

	public Department updatedDepartment(Long id, Department department) {
		Department existingDepartment = departmentRepository.findById(id)
									.orElseThrow(() -> new RuntimeException("Department not found"));
		
		existingDepartment.setDepartmentName(department.getDepartmentName());
		existingDepartment.setUpdatedAt(new Date());
		
		return departmentRepository.save(existingDepartment);
	}

	public String deleteDepartment(Long id) {
		Department existingDepartment = departmentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Department not found"));
		departmentRepository.delete(existingDepartment);
		return "Deprtment Deleted Sucessfully";
	}

}
