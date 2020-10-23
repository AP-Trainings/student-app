package com.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.entity.StudentDetail;
import com.school.helper.SchoolRestResponse;
import com.school.service.StudentDetailService;

@RestController
public class StudentDetailController {
	
	private StudentDetailService studentDetailService;
	
	@Autowired
	public StudentDetailController(StudentDetailService studentDetailService) {
		this.studentDetailService = studentDetailService;
	}
	
	@GetMapping("/student-details")
	public SchoolRestResponse<List<StudentDetail>> findAll() {
		List<StudentDetail> studentDetailList = studentDetailService.findAll();
		return new SchoolRestResponse<List<StudentDetail>>(HttpStatus.OK, "Students Found", studentDetailList);
	}
	
	@GetMapping(path="/getStudentDetail/{student_detail_id}")
	public SchoolRestResponse<StudentDetail> getStudentDetailById(@PathVariable int student_detail_id) {
		StudentDetail studentDetail = studentDetailService.findById(student_detail_id);
		return new SchoolRestResponse<StudentDetail>(HttpStatus.OK, "Student Detail Found", studentDetail);
	}
	
	@PostMapping(path="/addStudentDetail")
	public SchoolRestResponse<String> addStudentDetail(@RequestBody StudentDetail studentDetail) throws Exception {
		studentDetailService.save(studentDetail);
		return new SchoolRestResponse<String>(HttpStatus.OK, "Student added", "Student Added Successfully to database");
	}
	
	@DeleteMapping(value="/deleteStudentDetail/{student_detail_id}")
	public SchoolRestResponse<String> deleteStudentDetailById(@PathVariable int student_detail_id) {
		try {
			studentDetailService.deleteById(student_detail_id);
			return new SchoolRestResponse<String>(HttpStatus.OK, "Student Detail deleted", "Student Detail deleted Successfully from database");
		} catch (Exception e) {
			e.printStackTrace();
			return new SchoolRestResponse<String>(HttpStatus.INTERNAL_SERVER_ERROR, "Error Occured", "No Records Deleted");
		}
		
	}
}