package com.chulan.schoolmanagement.dto;

import java.util.Date;

import javax.persistence.MappedSuperclass;

import com.chulan.schoolmanagement.dto.CreatedAndModifiedDateDto;

/**
 * @author chulan
 * Basic details of a person to be used in a Data Transfer Object with inheritance
 */
@MappedSuperclass
public abstract class PersonDto extends CreatedAndModifiedDateDto{

	private String fName;
	private String lName;
	private String email;
	private String mobile;

	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @param createdDate
	 * @param lastModifiedDate
	 * @param fName
	 * @param lName
	 * @param email
	 * @param mobile
	 */
	
	public PersonDto(Date createdDate, Date lastModifiedDate, String fName, String lName, String email, String mobile) {
		super(createdDate, lastModifiedDate);
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.mobile = mobile;
	}

	public PersonDto() {
		// TODO Auto-generated constructor stub
	}
	
}
