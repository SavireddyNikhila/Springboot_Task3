package com.spring.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.entity.Employee;
import com.spring.repository.EmployeeRepository;

@Component
public class ValidateEmployee {

	@Autowired
	private EmployeeRepository employeeRepository;

	public String validate(Employee employee) {
		StringBuilder sb = new StringBuilder();
		List<Employee> emps = employeeRepository.findAll();

		// validating employee id
		if (Objects.nonNull(employee.getEmployeeId()) && !"".equalsIgnoreCase(employee.getEmployeeId())) {
			if (employee.getEmployeeId().length() <= 36) {
				for (int i = 0; i < emps.size(); i++) {
					if (emps.get(i).getEmployeeId().equals(employee.getEmployeeId()))
						sb.append("Employee Existed already with id: " + employee.getEmployeeId() + ",");
				}
			} else
				sb.append("Employee id should not exceed 36 characters");
		} else
			sb.append("Please enter employeeId");

		// validating firstname
		if (Objects.nonNull(employee.getFirstName()) && !"".equalsIgnoreCase(employee.getFirstName())) {
			if (!(employee.getFirstName().length() <= 50)) {
				sb.append(" max-length of firstname should not exceed 50,");
			}
		} else
			sb.append(" Please enter firstName,");

		// validating lastname
		if (Objects.nonNull(employee.getLastName()) && !"".equalsIgnoreCase(employee.getLastName())) {
			if (!(employee.getLastName().length() <= 50))
				sb.append(" max-length of lastname should not exceed 50,");
		}

		// validating gender
		if (Objects.nonNull(employee.getGender()) && !"".equalsIgnoreCase(employee.getGender())) {
			if (employee.getGender().length() == 1) {
				if (!(employee.getGender().matches("(?:[M|F|O])"))) {
					sb.append(" Please provide proper gender [M|F|O],");
				}
			} else {
				sb.append(" max-length of gender should be 1,");
			}
		}

		// validating email
		if (Objects.nonNull(employee.getEmailId()) && !"".equalsIgnoreCase(employee.getEmailId())) {

			if ((employee.getEmailId().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+[a-zA-Z]{2,}"))) {
				for (int i = 0; i < emps.size(); i++) {
					if (emps.get(i).getEmailId().equals(employee.getEmailId())) {
						sb.append(" duplicate email,");
					}
				}
			} else {
				sb.append(" Email should match with proper format,");
			}

		} else {
			sb.append(" Please enter email id,");
		}

		// validating phoneNumber
		if (Objects.nonNull(employee.getPhoneNumber()) && !"".equalsIgnoreCase(employee.getPhoneNumber())) {
			if ((employee.getPhoneNumber().matches("[\\\\\\\\\\\\\\\\+]+[0-9]{2}+[-]+[0-9]{10}"))) {
				for (int i = 0; i < emps.size(); i++) {
					if (emps.get(i).getPhoneNumber().equals(employee.getPhoneNumber())) {
						sb.append(" duplicate phone number,");
					}
				}
			} else
				sb.append(" PhoneNumber should match with proper format,");
		} else {
			sb.append(" Please enter phone Number,");
		}

		// validating password
		if ((Objects.nonNull(employee.getPassword()) && !"".equalsIgnoreCase(employee.getPassword()))) {
			if (((employee.getPassword().length() >= 8 && employee.getPassword().length() <= 20))) {
				if (!(employee.getPassword().matches("^(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[A-Za-z0-9]).{8,16}$"))) {
					sb.append(" Password should match with proper format");
				}
			} else {
				sb.append(" Password should be in the range of 8-20 characters");
			}

		} else {
			sb.append(" Please enter password");
		}

		return sb.toString();

	}

	public String ValidUpdate(Employee employee) {
		StringBuilder sb = new StringBuilder();
		List<Employee> emps = employeeRepository.findAll();

		// validating firstname
		if (Objects.nonNull(employee.getFirstName()) && !"".equalsIgnoreCase(employee.getFirstName())) {
			if (!(employee.getFirstName().length() <= 50)) {
				sb.append(" max-length of firstname should not exceed 50,");
			}
		}

		// validating lastname
		if (Objects.nonNull(employee.getLastName()) && !"".equalsIgnoreCase(employee.getLastName())) {
			if (!(employee.getLastName().length() <= 50))
				sb.append(" max-length of lastname should not exceed 50,");
		}

		// validating gender
		if (Objects.nonNull(employee.getGender()) && !"".equalsIgnoreCase(employee.getGender())) {
			if (employee.getGender().length() == 1) {
				if (!(employee.getGender().matches("(?:[M|F|O])"))) {
					sb.append(" Please provide proper gender [M|F|O],");
				}
			} else {
				sb.append(" max-length of gender should be 1,");
			}
		}

		// validating email
		if (Objects.nonNull(employee.getEmailId()) && !"".equalsIgnoreCase(employee.getEmailId())) {

			if ((employee.getEmailId().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+[a-zA-Z]{2,}"))) {
				for (int i = 0; i < emps.size(); i++) {
					if (emps.get(i).getEmailId().equals(employee.getEmailId())) {
						sb.append(" duplicate email,");
					}
				}
			} else {
				sb.append(" Email should match with proper format,");
			}

		}

		// validating phoneNumber
		if (Objects.nonNull(employee.getPhoneNumber()) && !"".equalsIgnoreCase(employee.getPhoneNumber())) {
			if ((employee.getPhoneNumber().matches("[\\\\\\\\\\\\\\\\+]+[0-9]{2}+[-]+[0-9]{10}"))) {
				for (int i = 0; i < emps.size(); i++) {
					if (emps.get(i).getPhoneNumber().equals(employee.getPhoneNumber())) {
						sb.append(" duplicate phone number,");
					}
				}
			} else
				sb.append(" PhoneNumber should match with proper format,");
		}

		// validating password
		if ((Objects.nonNull(employee.getPassword()) && !"".equalsIgnoreCase(employee.getPassword()))) {
			if (((employee.getPassword().length() >= 8 && employee.getPassword().length() <= 20))) {
				if (!(employee.getPassword().matches("^(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[A-Za-z0-9]).{8,16}$"))) {
					sb.append(" Password should match with proper format");
				}
			} else {
				sb.append(" Password should be in the range of 8-20 characters");
			}
		}
		return sb.toString();
	}
}
