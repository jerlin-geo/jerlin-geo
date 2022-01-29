package com.student.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
