package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.Entity.Student;
import com.student.service.StudentService;


@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentservice;

	@PostMapping
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentservice.saveStudent(student), HttpStatus.CREATED);	
	}

	@GetMapping("{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {	
		return new ResponseEntity<Student>(studentservice.getStudentById(id), HttpStatus.FOUND);
	}
	
	@GetMapping
	public List<Student> getAllStudent(){
		return studentservice.getAllStudent();
	}
	
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable("id") Long id) {
		studentservice.deleteById(id);
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudentById(@RequestBody Student student, @PathVariable("id") Long id){
		return new ResponseEntity<Student>(studentservice.updateStudentById(student, id), HttpStatus.OK);
	}
	

}
