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

import com.school.entity.StudentMark;
import com.school.helper.SchoolRestResponse;
import com.school.service.StudentMarkService;

@RestController
public class StudentMarkController {
	
	private StudentMarkService studentMarkService;
	
	@Autowired
	public StudentMarkController(StudentMarkService studentMarkService) {
		this.studentMarkService = studentMarkService;
	}
	
	@GetMapping("/student-marks")
	public SchoolRestResponse<List<StudentMark>> findAll() {
		List<StudentMark> studentMarkList = studentMarkService.findAll();
		return new SchoolRestResponse<List<StudentMark>>(HttpStatus.OK, "Student Mark Found", studentMarkList);
	}
	
	@GetMapping(path="/getStudentMark/{student_mark_id}")
	public SchoolRestResponse<StudentMark> getStudentMarkById(@PathVariable int student_mark_id) {
		StudentMark studentMark = studentMarkService.findById(student_mark_id);
		return new SchoolRestResponse<StudentMark>(HttpStatus.OK, "Student Mark Found", studentMark);
	}
	
	@PostMapping(path="/addStudentMark")
	public SchoolRestResponse<String> addStudentMark(@RequestBody StudentMark studentMark) throws Exception {
		studentMarkService.save(studentMark);
		return new SchoolRestResponse<String>(HttpStatus.OK, "Student Mark added", "Student Mark Added Successfully to database");
	}
	
	@DeleteMapping(value="/deleteStudentMark/{student_mark_id}")
	public SchoolRestResponse<String> deleteStudentMarkById(@PathVariable int student_mark_id) {
		try {
			studentMarkService.deleteById(student_mark_id);
			return new SchoolRestResponse<String>(HttpStatus.OK, "Student Mark deleted", "Student Mark deleted Successfully from database");
		} catch (Exception e) {
			e.printStackTrace();
			return new SchoolRestResponse<String>(HttpStatus.INTERNAL_SERVER_ERROR, "Error Occured", "No Records Deleted");
		}
		
	}
}