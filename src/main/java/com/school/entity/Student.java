package com.school.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="STUDENT")
@ToString @Getter @Setter
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STUDENT_ID")
	private Integer studentId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="STUDENT_DETAIL_ID")
	private StudentDetail studentDetail;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="STUDENT_CLASS",
			joinColumns = {@JoinColumn(name="STUDENT_ID")},
			inverseJoinColumns = {@JoinColumn(name="CLASS_ID")}
			)
	private Set<Class> classSet;
	
	@OneToMany(mappedBy="student")
	private List<StudentMark> studentMarkList;
	
	public Student(String firstName, String lastName, StudentDetail studentDetail) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentDetail = studentDetail;
	}
	
}
