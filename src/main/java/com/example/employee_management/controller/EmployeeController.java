package com.example.employee_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.employee_management.entity.Employee;
import com.example.employee_management.object.HelloResponse;
import com.example.employee_management.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {

        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {

        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PostMapping
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {

        return ResponseEntity.ok(employeeService.save(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,
                                                    @RequestBody Employee employee) {

        return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id) {

        return ResponseEntity.ok(employeeService.deleteEmployee(id));
    }
    
    @GetMapping("/hello")
    public HelloResponse hello(@RequestParam String name) {
    	HelloResponse helloResponse = new HelloResponse();
    	helloResponse.setName(name);
    	return helloResponse;
    }
    
    @PostMapping("/hello")
    public HelloResponse sayHello(@RequestBody HelloResponse helloResponse) {
    	return helloResponse;
    }
}