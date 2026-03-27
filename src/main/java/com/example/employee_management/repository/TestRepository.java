package com.example.employee_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.employee_management.entity.Task;

public interface TestRepository extends JpaRepository<Task,Long>{
}
