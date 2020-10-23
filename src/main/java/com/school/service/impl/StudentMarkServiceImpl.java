package com.school.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.school.dao.StudentMarkRepository;
import com.school.entity.StudentMark;
import com.school.service.StudentMarkService;

@Service
public class StudentMarkServiceImpl implements StudentMarkService {

	private StudentMarkRepository studentMarkRepository;
	
	public StudentMarkServiceImpl(StudentMarkRepository studentMarkRepository) {
		this.studentMarkRepository = studentMarkRepository;
	}
	
	@Override
	public List<StudentMark> findAll() {
		return studentMarkRepository.findAll();
	}
	

	@Override
	public StudentMark findById(int markId) {
		Optional<StudentMark> optionalMark = studentMarkRepository.findById(markId);
		StudentMark studentMark = null;
		if (optionalMark.isPresent()) {
			studentMark = optionalMark.get();
		} else {
			throw new RuntimeException("Did not find employee with id - " + markId);
		}
		return studentMark;
	}

	@Override
	public void save(StudentMark studentMark) {
		studentMarkRepository.save(studentMark);
	}

	@Override
	public void deleteById(int markId) {
		studentMarkRepository.deleteById(markId);
	}

}
