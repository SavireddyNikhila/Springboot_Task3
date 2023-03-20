package com.spring.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Employee;
import com.spring.exceptions.EmployeeException;
import com.spring.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ValidateEmployee validateEmployee;

	@Override
	public Employee createEmployee(Employee employee) throws EmployeeException {
		String str = validateEmployee.validate(employee);
		if (!"".equalsIgnoreCase(str))
			throw new EmployeeException(str);

		employee.setEmpCreatedDate(LocalDate.now());
		employee.setEmpUpdatedDate(LocalDate.now());
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> createBatchEmployees(List<Employee> employees) throws EmployeeException {
		for (int i = 0; i < employees.size(); i++) {
			String str = validateEmployee.validate(employees.get(i));

			if (!"".equalsIgnoreCase(str)) {
				throw new EmployeeException(
						"employee with id: " + employees.get(i).getEmployeeId() + " has following exceptions: " + str);
			}

			employees.get(i).setEmpCreatedDate(LocalDate.now());
			employees.get(i).setEmpUpdatedDate(LocalDate.now());
		}
		return employeeRepository.saveAll(employees);
	}

	@Override
	public Employee updateEmployee(String employeeId, Employee employee) throws EmployeeException {
		Optional<Employee> emp = employeeRepository.findById(employeeId);
		if(!emp.isPresent()) {
			throw new EmployeeException("Employee not found with the given id: "+employeeId);
		}
		else {
			Employee empDB = employeeRepository.findById(employeeId).get();
			String str=validateEmployee.ValidUpdate(employee);
			if(!"".equalsIgnoreCase(str)) {
				throw new EmployeeException(str);
			}
			else {
				if (Objects.nonNull(employee.getFirstName()) && !"".equalsIgnoreCase(employee.getFirstName()))
					empDB.setFirstName(employee.getFirstName());
				if (Objects.nonNull(employee.getLastName()) && !"".equalsIgnoreCase(employee.getLastName()))
					empDB.setLastName(employee.getLastName());
				if (Objects.nonNull(employee.getGender()) && !"".equalsIgnoreCase(employee.getGender()))
					empDB.setGender(employee.getGender());
				if (Objects.nonNull(employee.getEmailId()) && !"".equalsIgnoreCase(employee.getEmailId()))
					empDB.setEmailId(employee.getEmailId());
				if (Objects.nonNull(employee.getPhoneNumber()) && !"".equalsIgnoreCase(employee.getPhoneNumber()))
					empDB.setPhoneNumber(employee.getPhoneNumber());
				if (Objects.nonNull(employee.getPassword()) && !"".equalsIgnoreCase(employee.getPassword()))
					empDB.setPassword(employee.getPassword());
				if (Objects.nonNull(employee.getDateOfBirth()))
					empDB.setDateOfBirth(employee.getDateOfBirth());
				if (Objects.nonNull(employee.getProfilePhoto()) && !"".equalsIgnoreCase(employee.getProfilePhoto()))
					empDB.setProfilePhoto(employee.getProfilePhoto());
				if (Objects.nonNull(employee.getEmpCreatedDate()))
					empDB.setEmpCreatedDate(employee.getEmpCreatedDate());
				if (Objects.nonNull(employee.getEmpUpdatedDate()))
					empDB.setEmpUpdatedDate(employee.getEmpUpdatedDate());
				if (Objects.nonNull(employee.getDepartment()))
					empDB.setDepartment(employee.getDepartment());
				if (Objects.nonNull(employee.getDesignation()))
					empDB.setDesignation(employee.getDesignation());
			}
		return employeeRepository.save(empDB);
		}
	}


	@Override
	public List<Employee> getAllEmployees() throws EmployeeException {
		List<Employee> emps=employeeRepository.findAll();
		if(emps.size()==0)
			throw new EmployeeException("Employee is empty");
		return emps;
	}

	@Override
	public List<Employee> getEmployeesCreateDateBetween(LocalDate date1, LocalDate date2) throws EmployeeException {
		List<Employee> emps= employeeRepository.findByCreatedDateBetween(date1, date2);
		if(emps.size()==0)
			throw new EmployeeException("There is no employee created between these mentioned dates");
		return emps;
	}

	@Override
	public void deleteEmployee(String employeeId) throws EmployeeException {
		Optional<Employee> emp = employeeRepository.findById(employeeId);
		if(!emp.isPresent())
			throw new EmployeeException("Employee not found with the given id: "+employeeId); 
		employeeRepository.deleteById(employeeId);
	}

}
