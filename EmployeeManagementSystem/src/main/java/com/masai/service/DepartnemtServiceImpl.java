package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.Department;
import com.masai.entities.Employee;
import com.masai.exception.DepartmentNotFound;
import com.masai.repositry.DepartmentDao;
import com.masai.repositry.EmployeeDao;


@Service
public class DepartnemtServiceImpl implements DepartnemtService{

	@Autowired
	private DepartmentDao dDao;
	
	@Autowired
	private EmployeeDao empDao;
	
	
	@Override
	public List<Employee> getAllEmployeesByDepatName(String deptName)throws DepartmentNotFound {
		
		Optional<Department> dept =  dDao.findByDeptName(deptName);
		
		if(dept.isPresent())
		{
			List<Employee> emps =  dept.get().getEmps();
			return emps;
//			dept.get().getEmps().
		}
		else
		throw new DepartmentNotFound("Depart with emp not found");
	}

}
