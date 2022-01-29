package com.student.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.student.Dao.StudentRepository;
import com.student.Entity.Student;
import com.student.exception.StudentNotFoundException;


@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentrepository;

	@Override
	public Student saveStudent(@RequestBody Student student) {
		return studentrepository.save(student);	
	}

	@Override
	public Student getStudentById(Long id) {
		return studentrepository.findById(id).orElseThrow(()-> new StudentNotFoundException("Student NOT FOUND"));
	}

	@Override
	public List<Student> getAllStudent() {
		return studentrepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		if (studentrepository.existsById(id)) {
			studentrepository.deleteById(id);	
		}
		else {
			throw new StudentNotFoundException("Student NOT FOUND");
		}	
	}

	@Override
	public Student updateStudentById(Student student, Long id) {
			Student existingStudent = studentrepository.findById(id).orElse(new Student());
			existingStudent.setName(student.getName());
			existingStudent.setDob(student.getDob());
			studentrepository.save(existingStudent);
			return existingStudent;
		}	

	}
	
	



