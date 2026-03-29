package com.example.employee_management.service;

import com.example.employee_management.object.EmployeeDTO;
import com.example.employee_management.entity.Employee;
import com.example.employee_management.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    public Employee save(EmployeeDTO dto) {

        log.info("Saving employee: {}", dto.getName());

        Employee emp = new Employee();
        emp.setName(dto.getName());
        emp.setEmail(dto.getEmail());
        emp.setRole(dto.getRole());

        return repository.save(emp);
    }

    public Page<Employee> getEmployees(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    public Employee getEmployeeById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee updateEmployee(long id, EmployeeDTO dto) {

        Employee emp = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        emp.setName(dto.getName());
        emp.setEmail(dto.getEmail());
        emp.setRole(dto.getRole());

        return repository.save(emp);
    }

    public String deleteEmployee(long id) {
        repository.deleteById(id);
        return "Employee deleted successfully";
    }
}