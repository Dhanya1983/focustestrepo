package com.management.employee.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import com.management.employee.entity.Employee;
import com.management.employee.exception.BusinessException;
import com.management.employee.repository.EmployeeRepository;
import com.management.employee.utility.DateValidity;

@Service
public class EmployeeService implements EmployeeServiceInterface {
	Logger log = LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
	EmployeeRepository employeeRepository;
	
 // 700 series Error Status codes provided for Business Exception
	
	@Override
	public Employee addEmployee(Employee employee) {
		// Save an Employee
		log.info("addEmployee in EmployeeService invoked ");
		log.info("Employee name to be inserted is " +employee.getEmployeeName());
		if (employee.getEmployeeName().isEmpty() || (employee.getEmployeeName().length() == 0)) {
			throw new BusinessException("701", "Please provide Employee name as it is empty now. ");
		}
		if (employee.getPanNumber().isEmpty() || (employee.getPanNumber().length() == 0)) {
			throw new BusinessException("702", "Please provide Pan Number as it is empty now. ");
		}
		/**
		 * Assuming that date will always appear from the front end and front end validation will be 
		 * handled to check separators of day, month and year ie, / or -. checkValidDate to check the range 
		 * of values passed to day, month and year object and doesn't check the format of dates.
		 */
		try {
			if (DateValidity.checkValidDate(employee.getDateOfBirth())) {
				throw new BusinessException("703", "Please provide a valid date. ");
			}	
			Employee savedEmployee = employeeRepository.save(employee);
			log.info("Employee saved to database successfully. ");
			return savedEmployee;
		} 
		catch (IllegalArgumentException e) {
			throw new BusinessException("704", "Employee Object is null. Exception is " + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("705",
					"Something went wrong while adding an employee in EmployeeService layer. Exception is " + e.getMessage());
		}
	}


	@Override
	public List<Employee> getAllEmployee() {
		// Get the list of all Employee
		List<Employee> empList =null;
		try {
			log.info("getAllEmployee in EmployeeService invoked ");
			empList = employeeRepository.findAll();	
			log.info("Employee list fetched from database.");
		} catch (Exception e) {
			throw new BusinessException("706",
					"Something went wrong while fetching all employees in EmployeeService layer. Exception is " + e.getMessage());
		}
		if (empList.isEmpty())
			throw new BusinessException("707", "Employee doesnot exist, hence nothing to display. ");
		return empList;
	}

	@Override
	public Employee getEmployeeById(int empid) {
		// Retrieve an Employee By Id
		try {
			//log.info("getEmployeeById in EmployeeService invoked ");
			//log.info("Employee Id fetched is "+empid);
			return employeeRepository.findById(empid).get();
			
		//} catch (IllegalArgumentException e) {
		} catch (InternalServerError e) {
			throw new BusinessException("708", "Employee Id doesnot exist in database.Please try with a new id. ");
		} catch (java.util.NoSuchElementException e) {
			throw new BusinessException("709",
					"Something went wrong while fetching an employee by id in EmployeeService layer. Exception is " + e.getMessage());
		}
	}

	@Override
	public void deleteEmployeeById(int empid) {
		// Delete an Employee By Id
		try {
			log.info("deleteEmployeeById in EmployeeService invoked ");
			employeeRepository.deleteById(empid);
			log.info("Employee Id deleted is "+empid);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("710", "Employee Id is null.Please try with a new id. Exception is " + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("711",
					"Something went wrong while deleting an employee in EmployeeService layer. Exception is " + e.getMessage());
		}
	}


	@Override
	public Employee updateEmployee(Employee employee) {
		// Update an Employee
		log.info("updateEmployee in EmployeeService invoked ");
		log.info("Employee updated is "+ employee.getEmployeeName());
				if (employee.getEmployeeName().isEmpty() || (employee.getEmployeeName().length() == 0)) {
					throw new BusinessException("712", "Please provide Employee name as it is empty now. ");
				}
				if (employee.getPanNumber().isEmpty() || (employee.getPanNumber().length() == 0)) {
					throw new BusinessException("713", "Please provide Pan Number as it is empty now. ");
				}
				/**
				 * Assuming that date will always appear from the front end and front end validation will be 
				 * handled to check separators of day, month and year ie, / or -. checkValidDate to check the range 
				 * of values passed to day, month and year object and doesn't check the format of dates.
				 */
				try {
					if (DateValidity.checkValidDate(employee.getDateOfBirth())) {
						throw new BusinessException("714", "Please provide a valid date. ");
					}
					
					Employee savedEmployee = employeeRepository.save(employee);
					log.info("Employee updated to database successfully. ");
					return savedEmployee;
				} 
				catch (IllegalArgumentException e) {
					throw new BusinessException("715", "Employee Object is null. Exception is " + e.getMessage());
				} catch (Exception e) {
					throw new BusinessException("716",
							"Something went wrong while adding an employee in EmployeeService layer. Exception is " + e.getMessage());
				}
	}

}
