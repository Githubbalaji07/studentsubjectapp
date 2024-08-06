package com.balajichavan.StudentSubjectApp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {
	
	@ExceptionHandler(StudentNotExistException.class)
	public ResponseEntity<String> hadleException(StudentNotExistException except){
		return new ResponseEntity<>(except.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SubjectNotExistException.class)
	public ResponseEntity<String> hadleException(SubjectNotExistException except){
		return new ResponseEntity<>(except.getMessage(),HttpStatus.NOT_FOUND);
	}
}
