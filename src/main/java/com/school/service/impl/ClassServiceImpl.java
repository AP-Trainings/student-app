package com.school.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.school.dao.ClassRepository;
import com.school.entity.Class;
import com.school.service.ClassService;

@Service
public class ClassServiceImpl implements ClassService {

	private ClassRepository classRepository;
	
	public ClassServiceImpl(ClassRepository classRepository) {
		this.classRepository = classRepository;
	}
	
	@Override
	public List<Class> findAll() {
		return classRepository.findAll();
	}
	

	@Override
	public Class findById(int classId) {
		Optional<Class> optionalClass = classRepository.findById(classId);
		Class classObject = null;
		if (optionalClass.isPresent()) {
			classObject = optionalClass.get();
		} else {
			throw new RuntimeException("Did not find class with id - " + classId);
		}
		return classObject;
	}

	@Override
	public void save(Class classObject) {
		classRepository.save(classObject);
	}

	@Override
	public void deleteById(int classId) {
		classRepository.deleteById(classId);
	}

}
