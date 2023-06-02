package com.habib.hr.dto;

import java.time.LocalDate;

public class EmployeeDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private LocalDate hireDate;
	private JobDTO job;
	private Integer salary;
	private Double commissionPct;
	private EmployeeDTO manager;
	private DepartmentDTO department;

	public EmployeeDTO() {
	}

	public EmployeeDTO(Long id, String firstName, String lastName, String email, String phoneNumber, LocalDate hireDate,
			JobDTO job, Integer salary, Double commissionPct, EmployeeDTO manager, DepartmentDTO department) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.job = job;
		this.salary = salary;
		this.commissionPct = commissionPct;
		this.manager = manager;
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public JobDTO getJob() {
		return job;
	}

	public void setJob(JobDTO job) {
		this.job = job;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Double getCommissionPct() {
		return commissionPct;
	}

	public void setCommissionPct(Double commissionPct) {
		this.commissionPct = commissionPct;
	}

	public EmployeeDTO getManager() {
		return manager;
	}

	public void setManager(EmployeeDTO manager) {
		this.manager = manager;
	}

	public DepartmentDTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}

}
