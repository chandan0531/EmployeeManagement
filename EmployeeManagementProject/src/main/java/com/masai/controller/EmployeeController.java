package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.masai.entities.Department;
import com.masai.entities.Employee;
import com.masai.service.DepartmentServiceImpl;
import com.masai.service.EmployeeServiceImpl;

public class EmployeeController {
	
	@Autowired
	private DepartmentServiceImpl deptService;
	
	
	@Autowired
	private EmployeeServiceImpl empService;
	
	
	@PostMapping("/employee")
	ResponseEntity<Employee> addEmployeeHandller(@RequestBody Employee emp){
		
		Employee employee =  empService.saveEmployee(emp);
		
		return new ResponseEntity<Employee>(employee, HttpStatus.ACCEPTED);
		
		
	}
	
	
	
	@PostMapping("/department")
	ResponseEntity<Department> addEmployeeHandller(@RequestBody Department dept){
		
		Department depart =  deptService.addDepartment(dept);
		
		return new ResponseEntity<Department>(depart, HttpStatus.ACCEPTED);
		
		
	}
}
