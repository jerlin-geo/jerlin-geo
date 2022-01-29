package com.student.service;

import java.util.List;
import com.student.Entity.Student;

public interface StudentService {
	
	Student saveStudent(Student student);
	
    Student getStudentById( Long id);

	List<Student> getAllStudent();
	
	void deleteById(Long id);

	Student updateStudentById(Student student, Long id);
		

}
