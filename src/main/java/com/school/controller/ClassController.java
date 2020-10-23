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

import com.school.entity.Class;
import com.school.helper.SchoolRestResponse;
import com.school.service.ClassService;

@RestController
public class ClassController {
	
	private ClassService classService;
	
	@Autowired
	public ClassController(ClassService classService) {
		this.classService = classService;
	}
	
	@GetMapping("/classes")
	public SchoolRestResponse<List<Class>> findAll() {
		List<Class> classList = classService.findAll();
		return new SchoolRestResponse<List<Class>>(HttpStatus.OK, "Classes Found", classList);
	}
	
	@GetMapping(path="/getClass/{class_id}")
	public SchoolRestResponse<Class> getClassbyId(@PathVariable int class_id) {
		Class classObject = classService.findById(class_id);
		return new SchoolRestResponse<Class>(HttpStatus.OK, "Class Found", classObject);
	}
	
	@PostMapping(path="/addClass")
	public SchoolRestResponse<String> addClass(@RequestBody Class classObject) throws Exception {
		classService.save(classObject);
		return new SchoolRestResponse<String>(HttpStatus.OK, "Class added", "Class Added Successfully to database");
	}
	
	@DeleteMapping(value="/deleteClass/{class_id}")
	public SchoolRestResponse<String> deleteClassById(@PathVariable int class_id) {
		try {
			classService.deleteById(class_id);
			return new SchoolRestResponse<String>(HttpStatus.OK, "Class deleted", "Class Deleted from database");
		} catch (Exception e) {
			e.printStackTrace();
			return new SchoolRestResponse<String>(HttpStatus.INTERNAL_SERVER_ERROR, "Error Occured", "No Records Deleted");
		}
		
	}
}