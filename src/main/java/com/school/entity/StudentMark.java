package com.school.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="STUDENT_MARK")
@NoArgsConstructor
@Getter @Setter @ToString
public class StudentMark {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MARK_ID")
	private Integer markId;
	
	@Column(name="SUBJECT")
	private String subject;
	
	@Column(name="MARKS")
	private Integer marks;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ID_STUDENT")
	private Student student;
}
