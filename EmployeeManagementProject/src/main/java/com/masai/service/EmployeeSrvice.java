package com.masai.service;

import java.util.List;

import com.masai.entities.Employee;
import com.masai.exception.EmployeeNotFound;

public interface EmployeeSrvice {
	
	public Employee saveEmployee(Employee emp);
	
	public List<Employee> getAllEmployee() throws EmployeeNotFound;
	
	public String updateEmployee(Integer id, Double salary)throws EmployeeNotFound;
	
	public Employee deleteEmployee(Integer id)throws EmployeeNotFound;
	
	public List<Employee> getAllEmployeeByDept( Integer id)throws EmployeeNotFound;
}
