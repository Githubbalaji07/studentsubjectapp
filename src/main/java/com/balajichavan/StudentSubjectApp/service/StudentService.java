package com.balajichavan.StudentSubjectApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.balajichavan.StudentSubjectApp.model.Student;
import com.balajichavan.StudentSubjectApp.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public Student storeStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	public List<Student> getAllStudentt() {
		return studentRepository.findAll();
	}
	
	public Optional<Student> getStudent(@PathVariable Integer id) {
		return studentRepository.findById(id);
	}
	
	public void deleteStudent(@PathVariable Integer id) {
		studentRepository.deleteById(id);
	}


}
