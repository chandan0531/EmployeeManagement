package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.Department;
import com.masai.entities.Employee;
import com.masai.exception.EmployeeNotFound;
import com.masai.repositry.DepartmentDao;
import com.masai.repositry.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeDao eDao;
	
	
	@Autowired
	private DepartmentDao dDao;
	
	
	
	
	@Override
	public Employee saveEmployee(Employee emp) {
		eDao.findById(emp.getEmpId());
		
		 Department dept =  emp.getDepts();
		 dept.getEmps().add(emp);
		 dDao.save(dept);
		return eDao.save(emp);
	}

	@Override
	public List<Employee> getAllEmployee() throws EmployeeNotFound {
		
		List<Employee> emps =  eDao.findAll();
		
		if(emps.size()>0)
		{
			return emps;
		}
		else
			throw new EmployeeNotFound("Employee not Found");
	}

	@Override
	public String updateEmployee(Integer id, Double salary) throws EmployeeNotFound {
		
		Optional<Employee> emp =  eDao.findById(id);
		
		if(emp.isPresent())
		{
			Employee empupadte = emp.get();
			empupadte.setSalary(empupadte.getSalary() + salary);
			eDao.save(empupadte);
			return "Employee Udated"; 
		}
		else
			throw new EmployeeNotFound("Employee not Updated");
	
	}

	@Override
	public Employee deleteEmployee(Integer id) throws EmployeeNotFound {
		
		Optional<Employee> emp =  eDao.findById(id);
		
		if(emp.isPresent())
		{
			Employee existing = emp.get();
			eDao.delete(existing);
			return existing;
		}
		else
		{
			throw new EmployeeNotFound("Employee not deleted");
		}
		
	}

	@Override
	public List<Employee> getAllEmployeeByDept(Integer id) throws EmployeeNotFound {
		// TODO Auto-generated method stub
		return null;
	}

}
