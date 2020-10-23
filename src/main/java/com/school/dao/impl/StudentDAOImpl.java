package com.school.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.school.dao.StudentDAO;
import com.school.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	private EntityManager entityManager;
	
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public List<Student> findAll() {
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			Query<Student> studentQuery = currentSession.createQuery("from Student", Student.class);
			List<Student> students = studentQuery.getResultList();
			System.out.println(students);
			return students;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public Student findById(int studentId) {
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			Student student = currentSession.get(Student.class, studentId);
			return student;	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public void save(Student student) {
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.saveOrUpdate(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	@Transactional
	public void deleteById(int studentId) {
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			Query deleteQuery = currentSession.createQuery("delete from Student where id =: deleteStudentId");
			deleteQuery.setParameter("deleteStudentId", studentId);
			deleteQuery.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
