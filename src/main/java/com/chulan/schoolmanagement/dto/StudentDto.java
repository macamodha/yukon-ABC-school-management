package com.chulan.schoolmanagement.dto;

import java.util.Date;

/**
 * @author chulan
 * Student Data Transfer Object
 */

public class StudentDto extends PersonDto {
	
	private Long stuId;
	private String studentType; // Internal = I or External = E
	private String gender; // Male = M or Female = F
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
	public StudentDto(Date createdDate, Date lastModifiedDate, String fName, String lName, String email, String mobile,
			Long stuId, String studentType, String gender, String status) {
		super(createdDate, lastModifiedDate, fName, lName, email, mobile);
		this.stuId = stuId;
		this.studentType = studentType;
		this.gender = gender;
		this.status = status;
	}

	/**
	 * @param createdDate
	 * @param lastModifiedDate
	 * @param fName
	 * @param lName
	 * @param email
	 * @param mobile
	 */
	public StudentDto(Date createdDate, Date lastModifiedDate, String fName, String lName, String email,
			String mobile) {
		super(createdDate, lastModifiedDate, fName, lName, email, mobile);
		// TODO Auto-generated constructor stub
	}
	
	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
