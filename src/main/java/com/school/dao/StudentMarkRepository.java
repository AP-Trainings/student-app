package com.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.entity.StudentMark;

public interface StudentMarkRepository extends JpaRepository<StudentMark, Integer> {

}
