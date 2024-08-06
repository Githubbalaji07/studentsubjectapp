package com.balajichavan.StudentSubjectApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balajichavan.StudentSubjectApp.model.Student;
import com.balajichavan.StudentSubjectApp.repository.SubjectRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
