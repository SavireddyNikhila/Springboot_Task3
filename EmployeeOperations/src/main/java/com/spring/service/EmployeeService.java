package com.spring.service;

import java.time.LocalDate;
import java.util.List;

import com.spring.entity.Employee;
import com.spring.exceptions.EmployeeException;

public interface EmployeeService {

	Employee createEmployee(Employee employee) throws EmployeeException;

	List<Employee> createBatchEmployees(List<Employee> employees) throws EmployeeException;

	Employee updateEmployee(String employeeId,Employee employee) throws EmployeeException;

	List<Employee> getAllEmployees() throws EmployeeException;

	void deleteEmployee(String employeeId) throws EmployeeException;

	List<Employee> getEmployeesCreateDateBetween(LocalDate date1, LocalDate date2) throws EmployeeException;


}
