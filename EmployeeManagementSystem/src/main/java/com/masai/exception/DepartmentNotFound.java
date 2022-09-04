package com.masai.exception;

public class DepartmentNotFound extends RuntimeException{

	public DepartmentNotFound() {
		
	}
	
	public DepartmentNotFound(String message) {
		super(message);
	}
}
