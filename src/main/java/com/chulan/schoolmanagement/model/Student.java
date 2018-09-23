package com.chulan.schoolmanagement.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

/**
 * @author chulan
 * Student Model
 */
@Entity
@Table(name="student")
public class Student extends Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long stuId;
	
	@Size(min=1, max=1, message="Invalid Student Type Selected")
	private String studentType; // Internal = I or External = E
	
	@Size(min=1, max=1, message="Invalid Gender Selected")
	private String gender; // Male = M or Female = F

	@Size(min=1, max=1, message="Invalid Status Selected")
	private String status; // Active = A or Inactive = I

	/**
	 * @return the stuId
	 */
	public Long getStuId() {
		return stuId;
	}

	/**
	 * @param stuId the stuId to set
	 */
	public void setStuId(Long stuId) {
		this.stuId = stuId;
	}

	/**
	 * @return the studentType
	 */
	public String getStudentType() {
		return studentType;
	}

	/**
	 * @param studentType the studentType to set
	 */
	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @param createdDate
	 * @param lastModifiedDate
	 * @param fName
	 * @param lName
	 * @param email
	 * @param mobile
	 * @param stuId
	 * @param studentType
	 * @param gender
	 * @param status
	 */
	public Student(Date createdDate, Date lastModifiedDate, String fName, String lName,
			@Email(message = "Invalid Email Address Entered.") String email, String mobile, Long stuId,
			String studentType, String gender, String status) {
		super(createdDate, lastModifiedDate, fName, lName, email, mobile);
		this.stuId = stuId;
		this.studentType = studentType;
		this.gender = gender;
		this.status = status;
	}

	/**
	 * 
	 */
	public Student() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param createdDate
	 * @param lastModifiedDate
	 * @param fName
	 * @param lName
	 * @param email
	 * @param mobile
	 */
	public Student(Date createdDate, Date lastModifiedDate, String fName, String lName,
			@Email(message = "Invalid Email Address Entered.") String email, String mobile) {
		super(createdDate, lastModifiedDate, fName, lName, email, mobile);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param createdDate
	 * @param lastModifiedDate
	 */
	public Student(Date createdDate, Date lastModifiedDate) {
		super(createdDate, lastModifiedDate);
		// TODO Auto-generated constructor stub
	}
	
}
