package com.chulan.schoolmanagement.dto;

import java.util.Date;

/**
 * @author chulan
 * Teacher Data Transfer Object
 */

public class TeacherDto extends PersonDto {
	
	private Long teachId;
	private String gender; // Male = M or Female = F
	private String status; // Active = A or Inactive = I

	/**
	 * @return the teachId
	 */
	public Long getTeachId() {
		return teachId;
	}

	/**
	 * @param teachId the teachId to set
	 */
	public void setTeachId(Long teachId) {
		this.teachId = teachId;
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
	 * @param teachId
	 * @param gender
	 * @param status
	 */
	public TeacherDto(Date createdDate, Date lastModifiedDate, String fName, String lName, String email, String mobile,
			Long teachId, String gender, String status) {
		super(createdDate, lastModifiedDate, fName, lName, email, mobile);
		this.teachId = teachId;
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
	public TeacherDto(Date createdDate, Date lastModifiedDate, String fName, String lName, String email,
			String mobile) {
		super(createdDate, lastModifiedDate, fName, lName, email, mobile);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public TeacherDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
