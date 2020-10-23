package com.school.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.school.dao.StudentRepository;
import com.school.entity.Student;
import com.school.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}
	

	@Override
	public Student findById(int studentId) {
		Optional<Student> optionalStudent = studentRepository.findById(studentId);
		Student student = null;
		if (optionalStudent.isPresent()) {
			student = optionalStudent.get();
		} else {
			throw new RuntimeException("Did not find employee with id - " + studentId);
		}
		return student;
	}

	@Override
	public void save(Student student) {
		studentRepository.save(student);
	}

	@Override
	public void deleteById(int studentId) {
		studentRepository.deleteById(studentId);
	}

}
