package com.school.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.school.dao.StudentDetailRepository;
import com.school.entity.StudentDetail;
import com.school.service.StudentDetailService;

@Service
public class StudentDetailServiceImpl implements StudentDetailService {

	private StudentDetailRepository studentDetailRepository;
	
	public StudentDetailServiceImpl(StudentDetailRepository studentDetailRepository) {
		this.studentDetailRepository = studentDetailRepository;
	}
	
	@Override
	public List<StudentDetail> findAll() {
		return studentDetailRepository.findAll();
	}
	

	@Override
	public StudentDetail findById(int detailId) {
		Optional<StudentDetail> optionalStudentDetail = studentDetailRepository.findById(detailId);
		StudentDetail studentDetail = null;
		if (optionalStudentDetail.isPresent()) {
			studentDetail = optionalStudentDetail.get();
		} else {
			throw new RuntimeException("Did not find employee with id - " + detailId);
		}
		return studentDetail;
	}

	@Override
	public void save(StudentDetail studentDetail) {
		studentDetailRepository.save(studentDetail);
	}

	@Override
	public void deleteById(int detailId) {
		studentDetailRepository.deleteById(detailId);
	}

}
