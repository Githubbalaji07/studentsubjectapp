package com.balajichavan.StudentSubjectApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balajichavan.StudentSubjectApp.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject,Integer>{

}
