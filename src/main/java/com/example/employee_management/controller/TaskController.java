package com.example.employee_management.controller;

import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
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

import com.example.employee_management.entity.Task;
import com.example.employee_management.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	@PostMapping
	public ResponseEntity<Task> saveTask(@RequestBody Task task) {
		return ResponseEntity.ok(taskService.saveTask(task));
	}
	
	@GetMapping
	public ResponseEntity<List<Task>> getAllTasks() {
		return ResponseEntity.ok(taskService.getAllTasks());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Task>> getTaskById(@PathVariable Long id) {
		return ResponseEntity.ok(taskService.getTaskById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTask(@PathVariable Long id) {
		return ResponseEntity.ok(taskService.deleteTask(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<@Nullable Object> updateTask(@PathVariable Long id,@RequestBody Task updateTask) {
		return ResponseEntity.ok(taskService.updateTask(id,updateTask));
	}
}
