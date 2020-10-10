package com.school.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.entity.Student;
import com.school.helper.SchoolRestResponse;

@RestController
@RequestMapping(name="student-detail")
public class StudentDetailsController {
	
	@GetMapping("/getStudent")
	public String getStudent() {
		return "Greetings from Spring Boot!";
	}
	
	@PostMapping(value="/addStudent", consumes="application/json", produces="application/json")
	public @ResponseBody SchoolRestResponse<?> addStudent(@RequestBody Student student) {
		return null;
	}
}
