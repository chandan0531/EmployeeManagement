package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.Department;
import com.masai.entities.Employee;
import com.masai.exception.EmployeeNotFound;
import com.masai.repository.DepartmentDao;
import com.masai.repository.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeSrvice {
	
	@Autowired
	private EmployeeDao empDao;
	
	@Autowired
	private DepartmentDao deptDao;
	
	@Autowired
	private DepartmentServiceImpl depatImpl;
	
	
	
	
	
	@Override
	public Employee saveEmployee(Employee emp) {
		
		Optional<Employee> optemp =  empDao.findById(emp.getEmpId());
		
		if(!optemp.isPresent())
		{
//			deptDao.findByName(emp.getDepartment())
			
			Department d1 = new Department();
			d1.getEmployees().add(emp);
			
			emp.setDepartment(d1);
			return empDao.save(emp);
		}
		else
		{
			throw new EmployeeNotFound("Employee exist already");
		}
		
	
	}

	@Override
	public List<Employee> getAllEmployee() throws EmployeeNotFound {
		List<Employee> emps =  empDao.findAll();
		if(emps.size()>0)
		{
			return emps;
		}
		
		else
		{
			throw new EmployeeNotFound("Employee not fount");
		}
	}

	@Override
	public String updateEmployee(Integer id, Double salary) throws EmployeeNotFound {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee deleteEmployee(Integer id) throws EmployeeNotFound {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		//deptDao.findByName(emp.getDepartment());
		return null;
	}

	@Override
	public List<Employee> getAllEmployeeByDept(Integer id) throws EmployeeNotFound {
		// TODO Auto-generated method stub
		return null;
	}

}
