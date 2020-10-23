package com.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.school.entity.Class;;

public interface ClassRepository extends JpaRepository<Class, Integer> {

}
