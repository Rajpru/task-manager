package com.example.employee_management.service;
import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee_management.entity.Task;
import com.example.employee_management.repository.TestRepository;

@Service
public class TaskService {
	@Autowired
	private TestRepository  taskRepository;

	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}

	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	public Optional<Task> getTaskById(Long id) {
		return taskRepository.findById(id);
	}

	public String deleteTask(Long id) {
		Optional<Task> task = taskRepository.findById(id);
		
		if(!task.isEmpty()) {
			taskRepository.deleteById(id);
			return "task Deleted";
		} else {
			return "task not found";
		}
	}

	public @Nullable Object updateTask(Long id, Task updateTask) {
		// TODO Auto-generated method stub
		Task existing = taskRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Task not found"));

	    existing.setTaskName(updateTask.getTaskName());
	    existing.setDescription(updateTask.getDescription());
	    existing.setStatus(updateTask.getStatus());

	    return taskRepository.save(existing);
	}
	
	
	
}
