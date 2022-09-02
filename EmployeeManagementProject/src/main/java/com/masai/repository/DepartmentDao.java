package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entities.Department;


@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer> {
	
	
	public Department findByName(String name);
}
