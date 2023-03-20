package com.spring.service;

import java.util.List;

import com.spring.entity.Department;

public interface DepartmentService {

	Department createDepartment(Department department);

	List<Department> createBatchDepartments(List<Department> departments);

}
