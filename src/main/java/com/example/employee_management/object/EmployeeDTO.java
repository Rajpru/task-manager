package com.example.employee_management.object;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EmployeeDTO {
		
	  @NotNull
	  @NotBlank(message="employee name can not be empty")
	  private String name;
	  
	  @NotNull
	  @NotBlank(message="department name can not be empty")
	  private String department;
	  
	  @NotNull
	  @NotBlank(message="email id can not be empty")
	  private String email;
	  
	  private String role;
	  
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
