package com.masai.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer deptId;
	private String deptName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "depts")
	@JsonIgnore
	private List<Employee> emps = new ArrayList<>();
}
