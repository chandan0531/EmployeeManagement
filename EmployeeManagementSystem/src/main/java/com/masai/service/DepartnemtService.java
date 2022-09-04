package com.masai.service;

import java.util.List;

import com.masai.entities.Employee;
import com.masai.exception.DepartmentNotFound;

public interface DepartnemtService {
	
	
	public List<Employee> getAllEmployeesByDepatName(String deptName)throws DepartmentNotFound;
}
