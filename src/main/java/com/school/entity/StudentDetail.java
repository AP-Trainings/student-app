package com.school.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="STUDENT_DETAIL")
@EqualsAndHashCode(exclude = {"student"})
@Getter @Setter @ToString @NoArgsConstructor
public class StudentDetail implements Serializable {
	
	private static final long serialVersionUID = -6084206460121039844L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DETAIL_ID", nullable = false, unique = true)
	@JsonIgnore
	private Integer detailId;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="FATHER_NAME")
	private String fatherName;
	
	@Column(name="DATE_OF_BIRTH")
	private String dateOfBirth;
	
	@Column(name="CONTACT_NUMBER")
	private Integer contactNumber;
	
	@OneToOne(mappedBy="studentDetail", cascade=CascadeType.ALL)
	@JsonIgnoreProperties("studentDetail")
	@ToString.Exclude
	private Student student;

	public StudentDetail(String address, String fatherName, String dateOfBirth, Integer contactNumber) {
		this.address = address;
		this.fatherName = fatherName;
		this.dateOfBirth = dateOfBirth;
		this.contactNumber = contactNumber;
	}
	
}
