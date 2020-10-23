package com.school.service;

import java.util.List;

import com.school.entity.Student;
import com.school.entity.StudentMark;

public interface StudentMarkService {

	public List<StudentMark> findAll();

	public StudentMark findById(int markId);

	public void save(StudentMark studentMark);

	public void deleteById(int markId);


}
