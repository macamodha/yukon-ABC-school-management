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
 * Teacher Model
 */
@Entity
@Table(name="teacher")
public class Teacher extends Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long teachId;
	
	@Size(min=1, max=1, message="Invalid Gender Selected")
	private String gender; // Male = M or Female = F

	@Size(min=1, max=1, message="Invalid Status Selected")
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
	public Teacher(Date createdDate, Date lastModifiedDate, String fName, String lName,
			@Email(message = "Invalid Email Address Entered.") String email, String mobile, Long teachId, String gender,
			String status) {
		super(createdDate, lastModifiedDate, fName, lName, email, mobile);
		this.teachId = teachId;
		this.gender = gender;
		this.status = status;
	}

	/**
	 * 
	 */
	public Teacher() {
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
	public Teacher(Date createdDate, Date lastModifiedDate, String fName, String lName,
			@Email(message = "Invalid Email Address Entered.") String email, String mobile) {
		super(createdDate, lastModifiedDate, fName, lName, email, mobile);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param createdDate
	 * @param lastModifiedDate
	 */
	public Teacher(Date createdDate, Date lastModifiedDate) {
		super(createdDate, lastModifiedDate);
		// TODO Auto-generated constructor stub
	}
	
}
