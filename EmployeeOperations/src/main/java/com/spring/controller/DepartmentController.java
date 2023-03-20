package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Department;
import com.spring.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/createDepartment")
	public Department createDepartment(@RequestBody Department department) {
		return departmentService.createDepartment(department);
	}
	
	@PostMapping("/create/batchDepartments")
	public List<Department> createBatchDepartments(@RequestBody List<Department> departments){
		return departmentService.createBatchDepartments(departments);
	}
}
