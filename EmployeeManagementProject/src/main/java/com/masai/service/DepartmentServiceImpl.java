package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.Department;
import com.masai.exception.DepartmentNotFound;
import com.masai.repository.DepartmentDao;
import com.masai.repository.EmployeeDao;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private EmployeeDao empDao;
	
	@Autowired
	private DepartmentDao deptDao;
	
	
	@Override
	public Department addDepartment(Department dept) throws DepartmentNotFound {
			
		Optional<Department> opdep =  deptDao.findById(dept.getDeptId());
		
		if(opdep.isPresent())
		{
			return deptDao.save(dept);
		}
		
		else
		{
			throw new DepartmentNotFound("Already exist ");
		}
		
	}

}
