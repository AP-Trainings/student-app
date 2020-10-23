package com.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.entity.StudentDetail;

public interface StudentDetailRepository extends JpaRepository<StudentDetail, Integer> {

}
