package com.management.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.employee.entity.Employee;
import com.management.employee.exception.BusinessException;
import com.management.employee.exception.ControllerException;
import com.management.employee.service.EmployeeServiceInterface;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeServiceInterface employeeServiceInterface;
	
	 // 800 series Error Status codes provided for ControllerException

	@PostMapping("/saveEmployee")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		try {
			log.info("addEmployee in EmployeeController invoked ");
			log.info("Employee name to be inserted is "+employee.getEmployeeName());
			Employee employeeSaved = employeeServiceInterface.addEmployee(employee);
			log.info("Employee saved successfully. ");
			return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
			
		} catch (BusinessException e) {
			ControllerException controllerException = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(controllerException, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			ControllerException controllerException = new ControllerException("801",
					"Something went wrong while adding an employee in the controller layer. ");
			return new ResponseEntity<ControllerException>(controllerException, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllEmployee() {
		List<Employee> allEmployee = null;
		try {
			log.info("getAllEmployee in EmployeeController invoked ");
			allEmployee = employeeServiceInterface.getAllEmployee();
			log.info("Employee list fetched.");
			return new ResponseEntity<List<Employee>>(allEmployee, HttpStatus.OK);
		} catch (BusinessException e) {
			ControllerException controllerException = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(controllerException, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			ControllerException controllerException = new ControllerException("802",
					"Something went wrong while fetching all employees in the controller layer. ");
			return new ResponseEntity<ControllerException>(controllerException, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getEmployee/{empid}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("empid") int empid) {
		try {
			log.info("getEmployeeById in EmployeeController invoked ");
			Employee employeeById = employeeServiceInterface.getEmployeeById(empid);
			log.info("Employee Id fetched is "+employeeById);
			return new ResponseEntity<Employee>(employeeById,HttpStatus.OK);
		} catch (BusinessException e) {
			ControllerException controllerException = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(controllerException, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			ControllerException controllerException = new ControllerException("803",
					"Something went wrong while fetching an employee by Id in the controller layer. ");
			return new ResponseEntity<ControllerException>(controllerException, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deleteEmployee/{empid}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable("empid") int empid) {
		try {
			log.info("deleteEmployeeById in EmployeeController invoked ");
			employeeServiceInterface.deleteEmployeeById(empid);
			log.info("Employee Id deleted is " +empid);
			return new ResponseEntity<String>("Employee with id "+empid+ "deleted Successfully",HttpStatus.ACCEPTED);
		} catch (BusinessException e) {
			ControllerException controllerException = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(controllerException, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			ControllerException controllerException = new ControllerException("804",
					"Something went wrong while fetching an employee by Id in the controller layer. ");
			return new ResponseEntity<ControllerException>(controllerException, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updateEmployee")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
		try {
			log.info("updateEmployee in EmployeeController invoked ");
			Employee employeeUpdated = employeeServiceInterface.updateEmployee(employee);
			log.info("Employee updated is "+employee.getEmployeeName());
			return new ResponseEntity<Employee>(employeeUpdated, HttpStatus.CREATED);
		} catch (BusinessException e) {
			ControllerException controllerException = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(controllerException, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			ControllerException controllerException = new ControllerException("805",
					"Something went wrong while adding an employee in the controller layer. ");
			return new ResponseEntity<ControllerException>(controllerException, HttpStatus.BAD_REQUEST);
		}

	}

}
