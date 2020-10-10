package com.school.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="CLASS")
@NoArgsConstructor @Getter @Setter
public class Class {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CLASS_ID")
	private Integer classId;
	
	@Column(name="CLASS_NAME")
	private String className;
	
	@Column(name="TOTAL_STUDENTS")
	private Integer totalStudents;
	
	@ManyToMany(mappedBy="classSet")
	private Set<Student> studentSet;

	public Class(String className, Integer totalStudents) {
		this.className = className;
		this.totalStudents = totalStudents;
	}
	
}
