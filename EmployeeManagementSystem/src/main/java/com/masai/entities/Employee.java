package com.masai.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;
	private String name;
	private Double salary;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Department depts;
	
}
