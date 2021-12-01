package com.management.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
