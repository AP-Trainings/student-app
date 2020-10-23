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

import com.school.entity.Student;
import com.school.helper.SchoolRestResponse;
import com.school.service.StudentService;

@RestController
public class StudentController {
	
	private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping("/students")
	public SchoolRestResponse<List<Student>> findAll() {
		List<Student> studentList = studentService.findAll();
		return new SchoolRestResponse<List<Student>>(HttpStatus.OK, "Students Found", studentList);
	}
	
	@GetMapping(path="/getStudent/{student_id}")
	public SchoolRestResponse<Student> getStudentbyId(@PathVariable int student_id) {
		Student student = studentService.findById(student_id);
		return new SchoolRestResponse<Student>(HttpStatus.OK, "Student Found", student);
	}
	
	@PostMapping(path="/addStudent")
	public SchoolRestResponse<String> addStudent(@RequestBody Student student) throws Exception {
		studentService.save(student);
		return new SchoolRestResponse<String>(HttpStatus.OK, "Student added", "Student Added Successfully to database");
	}
	
	@DeleteMapping(value="/deleteStudent/{student_id}")
	public SchoolRestResponse<String> deleteStudentById(@PathVariable int student_id) {
		try {
			studentService.deleteById(student_id);
			return new SchoolRestResponse<String>(HttpStatus.OK, "Student deleted", "Student deleted Successfully from database");
		} catch (Exception e) {
			e.printStackTrace();
			return new SchoolRestResponse<String>(HttpStatus.INTERNAL_SERVER_ERROR, "Error Occured", "No Records Deleted");
		}
		
	}
}