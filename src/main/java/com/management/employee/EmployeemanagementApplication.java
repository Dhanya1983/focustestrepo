package com.management.employee;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.management.employee.entity.Department;
import com.management.employee.entity.Employee;
import com.management.employee.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeemanagementApplication {//implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagementApplication.class, args);
	}

	@Autowired
	EmployeeRepository empRepository;
	
	/**
	 *  To dload db with values on Spring Boot run
	 */
	
	/*
	@SuppressWarnings("deprecation")
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Department dep=new Department();
		dep.setDepartmentName("ITC");
		dep.setDepartmentHead("ITC Head");
		
		Employee emp =new Employee();
		emp.setEmployeeName("Vignesh");
		emp.setDateOfBirth( new java.sql.Date(2021, 11, 27));
		emp.setPanNumber("VIG1234");
		emp.setAddress("Test addresss");
		
		emp.setDepartment(dep);		
		dep.setEmployee(emp);
		
		empRepository.save(emp);
		
		
		
		
		//Second row add
		
		dep=new Department();
		dep.setDepartmentName("Business");
		dep.setDepartmentHead("Business Head");
		
		emp =new Employee();
		emp.setEmployeeName("Vinayaka");
		emp.setDateOfBirth( new java.sql.Date(2021, 11, 28));
		emp.setPanNumber("CSHH887");
		emp.setAddress("India");
		
		emp.setDepartment(dep);		
		dep.setEmployee(emp);
		
		empRepository.save(emp);
	}
*/
}
