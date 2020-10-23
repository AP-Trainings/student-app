package com.school.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="CLASS")
@EqualsAndHashCode(exclude= {"studentSet"})
@NoArgsConstructor @Getter @Setter @ToString
public class Class implements Serializable {
	
	private static final long serialVersionUID = -6850263394671725762L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CLASS_ID", nullable = false, unique = true)
	@JsonIgnore
	private Integer classId;
	
	@Column(name="CLASS_NAME")
	private String className;
	
	@Column(name="TOTAL_STUDENTS")
	private Integer totalStudents;
	
	@ManyToMany(mappedBy="classSet", cascade=CascadeType.ALL)
	@JsonIgnoreProperties("classSet")
	@ToString.Exclude
	private Set<Student> studentSet;

	public Class(String className, Integer totalStudents) {
		this.className = className;
		this.totalStudents = totalStudents;
	}
}
