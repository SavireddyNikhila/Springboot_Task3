package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.entity.Department;
import com.spring.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	private DepartmentRepository departmentRepo;
	
	@Override
	public Department createDepartment(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> createBatchDepartments(List<Department> departments) {
		// TODO Auto-generated method stub
		return null;
	}

}
