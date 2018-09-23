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
 * User Model
 */
@Entity
@Table(name="user")
public class User extends Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	
	@Size(min=4, message="Password must be at least 4 characters.")
	private String psw;

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the psw
	 */
	public String getPsw() {
		return psw;
	}

	/**
	 * @param psw the psw to set
	 */
	public void setPsw(String psw) {
		this.psw = psw;
	}

	/**
	 * @param createdDate
	 * @param lastModifiedDate
	 * @param fName
	 * @param lName
	 * @param email
	 * @param mobile
	 * @param userId
	 * @param psw
	 */
	public User(Date createdDate, Date lastModifiedDate, String fName, String lName,
			@Email(message = "Invalid Email Address Entered.") String email, String mobile, Long userId, String psw) {
		super(createdDate, lastModifiedDate, fName, lName, email, mobile);
		this.userId = userId;
		this.psw = psw;
	}

	/**
	 * 
	 */
	public User() {
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
	public User(Date createdDate, Date lastModifiedDate, String fName, String lName,
			@Email(message = "Invalid Email Address Entered.") String email, String mobile) {
		super(createdDate, lastModifiedDate, fName, lName, email, mobile);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param createdDate
	 * @param lastModifiedDate
	 */
	public User(Date createdDate, Date lastModifiedDate) {
		super(createdDate, lastModifiedDate);
		// TODO Auto-generated constructor stub
	}
	
}
