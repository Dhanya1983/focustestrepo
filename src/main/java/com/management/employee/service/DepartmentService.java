package com.management.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.employee.entity.Department;
import com.management.employee.repository.DepartmentRepository;

@Service
public class DepartmentService implements DepartmentServiceInterface {
	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public Department addDepartment(Department department) {
		
		Department savedDepartment= departmentRepository.save(department);
		return savedDepartment;
	}
	
	
}
