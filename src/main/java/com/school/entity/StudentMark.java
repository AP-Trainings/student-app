package com.school.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="STUDENT_MARK")
@EqualsAndHashCode(exclude= {"student"})
@Getter @Setter @ToString @NoArgsConstructor
public class StudentMark implements Serializable {
	
	private static final long serialVersionUID = -5559585661087761016L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MARK_ID", nullable = false, unique = true)
	@JsonIgnore
	private Integer markId;
	
	@Column(name="SUBJECT")
	private String subject;
	
	@Column(name="MARKS")
	private Integer marks;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ID_STUDENT")
	@JsonIgnoreProperties("studentMarkList")
	@ToString.Exclude 
	private Student student;

	public StudentMark(String subject, Integer marks) {
		this.subject = subject;
		this.marks = marks;
	}
	
}
