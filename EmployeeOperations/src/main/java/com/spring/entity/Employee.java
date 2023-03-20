package com.spring.entity;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

	@Id
	
	private String employeeId;
	private String firstName;
	private String lastName;
	private String gender;
	private String emailId;
	private String phoneNumber;
	private String password;
	private Date dateOfBirth;
	private String profilePhoto;
	private LocalDate empCreatedDate;
	private LocalDate empUpdatedDate;

	@ManyToOne(cascade=CascadeType.ALL)
	private Department department;

	@ManyToOne(cascade=CascadeType.ALL)
	private Designation designation;

}
