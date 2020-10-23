package com.school.service;

import java.util.List;

import com.school.entity.StudentDetail;

public interface StudentDetailService {

	public List<StudentDetail> findAll();

	public StudentDetail findById(int detailId);

	public void save(StudentDetail studentDetail);

	public void deleteById(int detailId);


}
