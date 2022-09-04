package com.masai.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.entities.Department;

@Repository
public interface DepartmentDao extends JpaRepository <Department, Integer> {
	
	
	public Optional<Department>findByDeptName(String deptName);
	
	
	@Query("select s.empName from Employee s where deptId =:deptId")
	public String getEmployee(@Param("roll") int roll);
}
