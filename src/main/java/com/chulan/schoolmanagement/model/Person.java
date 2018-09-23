package com.chulan.schoolmanagement.model;

import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

/**
 * @author chulan
 * Basic details of a person to be used in a Model with inheritance
 */
@MappedSuperclass
public abstract class Person extends CreatedAndModifiedDate{

	@Size(min=2, max=10,message="First Name should be between 2-10 characters.")
	private String fName;
	
	@Size(min=2, max=20,message="Last Name should be between 2-20 characters.")
	private String lName;
	
	@Size(min=1, message="Invalid Email Address Entered.")
	@Email(message="Invalid Email Address Entered.")
	private String email;
	
	@Size(min=10, max=10, message="Mobile No should be 10 digits.")
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
	public Person(Date createdDate, Date lastModifiedDate, String fName, String lName,
			@Email(message = "Invalid Email Address Entered.") String email, String mobile) {
		super(createdDate, lastModifiedDate);
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.mobile = mobile;
	}

	/**
	 * 
	 */
	public Person() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param createdDate
	 * @param lastModifiedDate
	 */
	public Person(Date createdDate, Date lastModifiedDate) {
		super(createdDate, lastModifiedDate);
		// TODO Auto-generated constructor stub
	}
	
	
}
