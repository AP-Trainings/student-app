package com.school.service;

import java.util.List;

import com.school.entity.Class;;

public interface ClassService {

	public List<Class> findAll();

	public Class findById(int classId);

	public void save(Class classObject);

	public void deleteById(int classId);


}
