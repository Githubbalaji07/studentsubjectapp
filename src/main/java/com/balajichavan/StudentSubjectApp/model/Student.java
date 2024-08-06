package com.balajichavan.StudentSubjectApp.model;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@OneToMany(mappedBy="student", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Subject> subjects=new HashSet<Subject>();
	
	//constructors
	public Student() {
	
	}
	
	public Student(String name) {
		this.name=name;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String object) {
		this.name = object;
	}

//	public Set<Subject> getSubjects() {
//		return subjects;
//	}
//
//	public void setSubjects(Set<Subject> subjects) {
//		this.subjects = subjects;
//	}
	
	
	
}
