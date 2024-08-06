package com.balajichavan.StudentSubjectApp.Exception;

public class SubjectNotExistException extends RuntimeException{
	
	public SubjectNotExistException() {
		// TODO Auto-generated constructor stub
	}
	
	public SubjectNotExistException(Integer id) {
		super("Subject Not EXist With Id = "+id);
	}
	
}
