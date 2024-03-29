package com.school.dao;

import java.util.List;

import com.school.entity.Student;

public interface StudentDAO {

	public List<Student> findAll();
	
	public Student findById(int studentId);
	
	public void save(Student student);
	
	public void deleteById(int studentId);
	
}
