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

import com.balajichavan.StudentSubjectApp.model.Subject;
import com.balajichavan.StudentSubjectApp.repository.SubjectRepository;

@Service
public class SubjectService {
	
	@Autowired
	SubjectRepository subjectRepository;
	
	public Subject storeSubject(@RequestBody Subject subject) {
		return subjectRepository.save(subject);
	}
	
	public List<Subject> getAllSubject() {
		return subjectRepository.findAll();
	}
	
	@GetMapping("/subject/{id}")
	public Optional<Subject> getSubject(@PathVariable Integer id) {
		return subjectRepository.findById(id);
	}
	
	@DeleteMapping("/subject/{id}")
	public void deleteSubject(@PathVariable Integer id) {
		 subjectRepository.deleteById(id);
	}


}
