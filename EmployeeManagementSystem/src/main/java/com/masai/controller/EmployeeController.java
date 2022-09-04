package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.Employee;
import com.masai.service.DepartnemtServiceImpl;
import com.masai.service.EmployeeService;

@RestController
public class EmployeeController {

	
	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private DepartnemtServiceImpl deptService;
	
	@PostMapping("/employee")
	ResponseEntity<Employee> addEmployeeHandller(@RequestBody Employee emp){
		
		Employee employee =  empService.saveEmployee(emp);
		
		return new ResponseEntity<Employee>(employee, HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/employees")
	ResponseEntity<List<Employee>> getAllEmployeeHandller(){
		
		List<Employee> employees =  empService.getAllEmployee();
		
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.ACCEPTED);
	}
	
	
	@PutMapping("/employee/{id}/{salary}")
	ResponseEntity<String> upadteEmployeeHandller(@PathVariable("id") Integer id,
												@PathVariable("salary") Double salary){
		
		 String str = empService.updateEmployee(id, salary);
		
		return new ResponseEntity<String>(str, HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/employee/{id}")
	ResponseEntity<Employee> addEmployeeHandller(@PathVariable("id") Integer id){
		
		Employee employee =  empService.deleteEmployee(id);
		
		return new ResponseEntity<Employee>(employee, HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/employees/{deptName}")
	ResponseEntity<List<Employee>> getAllEmployeeDeptHandler(@PathVariable("deptName") String deptName){
		
		List<Employee> emps = deptService.getAllEmployeesByDepatName(deptName);
		
		return new ResponseEntity<List<Employee>>(emps, HttpStatus.ACCEPTED);
	}
	
	
	
}
