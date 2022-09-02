package com.masai.service;

import com.masai.entities.Department;
import com.masai.exception.DepartmentNotFound;

public interface DepartmentService{
	
	public Department addDepartment(Department dept) throws DepartmentNotFound;
	
}
