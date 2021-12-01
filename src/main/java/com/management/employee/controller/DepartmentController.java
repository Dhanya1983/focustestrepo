package com.management.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.employee.entity.Department;
import com.management.employee.entity.Employee;
import com.management.employee.service.DepartmentServiceInterface;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentServiceInterface departmentServiceInterface;
	
	
	@PostMapping("/saveDepartment")
	// Adding a department
	public ResponseEntity<Department> addDepartment(@RequestBody Department department){
		Department deptSaved=departmentServiceInterface.addDepartment(department);
		return new ResponseEntity<Department>(deptSaved, HttpStatus.CREATED);
		
	}
}
