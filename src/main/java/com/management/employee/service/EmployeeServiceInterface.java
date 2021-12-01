package com.management.employee.service;

import java.util.List;

import com.management.employee.entity.Employee;

public interface EmployeeServiceInterface {

	public Employee addEmployee(Employee employee);

	public List<Employee> getAllEmployee();

	public Employee getEmployeeById(int empid);

	public void deleteEmployeeById(int empid);
	
	public Employee updateEmployee(Employee employee);

}
