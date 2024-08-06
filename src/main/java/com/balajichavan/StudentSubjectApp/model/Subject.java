package com.balajichavan.StudentSubjectApp.model;

import jakarta.persistence.*;

@Entity
public class Subject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@ManyToOne
    @JoinColumn(name="student_id")
	private Student student;

//getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubjectName() {
		return name;
	}

	public void setSubjectName(String subjectName) {
		name = subjectName;
	}	

}
