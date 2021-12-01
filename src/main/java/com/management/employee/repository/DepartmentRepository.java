package com.management.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.employee.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
