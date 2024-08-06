package com.balajichavan.StudentSubjectApp.Exception;


public class StudentNotExistException extends RuntimeException{
	
	public StudentNotExistException() {
		// TODO Auto-generated constructor stub
	}
	
	public StudentNotExistException(Integer id) {
		super("Student Not exist With Id = "+id);
	}
	
}
