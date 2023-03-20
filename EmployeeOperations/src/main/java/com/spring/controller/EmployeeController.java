package com.spring.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Employee;
import com.spring.exceptions.EmployeeException;
import com.spring.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/createEmployee")
	public Employee createEmployee(@RequestBody Employee employee) throws EmployeeException {
		return employeeService.createEmployee(employee);
	}
	
	@PostMapping("/create/BatchEmployees")
	public List<Employee> createbatchEmployees(@RequestBody List<Employee> employees) throws EmployeeException{
		return employeeService.createBatchEmployees(employees);
	}
	
	@PutMapping("/updateEmployee/{id}")
	public Employee updateEmployee(@PathVariable("id") String employeeId, @RequestBody Employee employee) throws EmployeeException {
		return employeeService.updateEmployee(employeeId,employee);	
	}
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() throws EmployeeException{
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/usersByDate/{date1}/{date2}")
	public List<Employee> fetchUsersCreateDateBetween(@PathVariable("date1") LocalDate Date1,
			@PathVariable("date2") LocalDate Date2) throws EmployeeException{
		return employeeService.getEmployeesCreateDateBetween(Date1, Date2);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") String employeeId) throws EmployeeException {
		employeeService.deleteEmployee(employeeId);
		return "deleted Successfully";
	}
}
