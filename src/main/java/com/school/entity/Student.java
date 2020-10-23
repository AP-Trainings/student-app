package com.school.entity;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="STUDENT")
@EqualsAndHashCode(exclude = {"studentDetail", "classSet", "studentMarkList"})
@Getter @Setter @ToString
@NoArgsConstructor
public class Student implements Serializable {

	private static final long serialVersionUID = -4400428495879998571L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STUDENT_ID", nullable = false, unique = true)
	@JsonIgnore
	private Integer studentId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="STUDENT_DETAIL_ID")
	@JsonIgnoreProperties("student")
	private StudentDetail studentDetail;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="STUDENT_CLASS",
			joinColumns = {@JoinColumn(name="STUDENT_ID")},
			inverseJoinColumns = {@JoinColumn(name="CLASS_ID")}
			)
	@JsonIgnoreProperties("studentSet")
	private Set<Class> classSet;
	
	@OneToMany(mappedBy="student", cascade=CascadeType.ALL)
	@JsonIgnoreProperties("student")
	private List<StudentMark> studentMarkList;
	
	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
}
