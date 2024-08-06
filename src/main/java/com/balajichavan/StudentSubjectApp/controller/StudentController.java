package com.balajichavan.StudentSubjectApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.balajichavan.StudentSubjectApp.Exception.StudentNotExistException;
import com.balajichavan.StudentSubjectApp.model.Student;
import com.balajichavan.StudentSubjectApp.repository.StudentRepository;
import com.balajichavan.StudentSubjectApp.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@Autowired
	StudentRepository studentRepo;
	
	@PostMapping("/api/student")
	public Student store(@RequestBody Student student) {
		return studentService.storeStudent(student);
	}
	
	@GetMapping("/api/student")
	public List<Student> getAll(){
		return studentService.getAllStudentt();
	}
	
	@GetMapping("/api/student/{id}")
	public Student getById(@PathVariable Integer id){
		return studentService.getStudent(id).orElseThrow(()->new StudentNotExistException(id));
	}
	
	@DeleteMapping("/api/student/{id}")
	public String delete(@PathVariable Integer id){
		
		 if(!studentRepo.existsById(id)) 
				throw new  StudentNotExistException(id);
		 
		 studentService.getStudent(id).get();
		 return "Delete Sucessfully Student with Id= "+id;
	}
	
	@PutMapping("/api/student/{id}")
	public String update(@PathVariable Integer id, @RequestBody Student newStudent){
		 Optional<Student> student=studentService.getStudent(id);
		 
		 if(!studentRepo.existsById(id)) 
				throw new  StudentNotExistException(id);
		 else {
		 if(student.isPresent()) {
			 Student existingStudent=student.get();
			 existingStudent.setName(newStudent.getName());
		 }
		 }
		 return "Sucessfully Updated Information Student with Id= "+id;
	}
}
