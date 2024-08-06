package com.balajichavan.StudentSubjectApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.balajichavan.StudentSubjectApp.Exception.SubjectNotExistException;
import com.balajichavan.StudentSubjectApp.model.Subject;
import com.balajichavan.StudentSubjectApp.repository.SubjectRepository;
import com.balajichavan.StudentSubjectApp.service.SubjectService;

@RestController
public class SubjectController {
	
	@Autowired
	SubjectService subjectService;
	
	@Autowired
	SubjectRepository subjectRepo;
	
	@PostMapping("/api/subject")
	public Subject store(@RequestBody Subject subject) {
		return subjectService.storeSubject(subject);
	}
	
	@GetMapping("/api/subject")
	public List<Subject> getAll() {
		return subjectService.getAllSubject();
	}
	
	@GetMapping("/api/subject/{id}")
	public Subject getById(@PathVariable Integer id) {
		 return subjectService.getSubject(id).orElseThrow(()->new SubjectNotExistException(id));
	}
	
	@DeleteMapping("/api/subject/{id}")
	public String delete(@PathVariable Integer id) {
		 
		 if(!subjectRepo.existsById(id)) 
				throw new  SubjectNotExistException(id);
		 
		 subjectService.getSubject(id).get();
		 return "Sucessfully Deleteed Subject with Id= "+id;
	}
	
	@PutMapping("/api/subject/{id}")
	public String update(@PathVariable Integer id,@RequestBody Subject newSub) {
		Optional<Subject> sub=subjectService.getSubject(id);
		
		if(!subjectRepo.existsById(id)) 
			throw new  SubjectNotExistException(id);
		else {
		if(sub.isPresent()) {
			Subject existingSub=sub.get();
			existingSub.setSubjectName(newSub.getSubjectName());
		}}
		 return "Sucessfully Deleted Subject with Id= "+id;
	}
	
	
}
