package com.chulan.schoolmanagement.dto;

import java.util.Date;

/**
 * @author chulan
 * User Data Transfer Object
 */

public class UserDto extends PersonDto {
	
	private Long userId;
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
	public UserDto(Date createdDate, Date lastModifiedDate, String fName, String lName, String email, String mobile,
			Long userId, String psw) {
		super(createdDate, lastModifiedDate, fName, lName, email, mobile);
		this.userId = userId;
		this.psw = psw;
	}

	/**
	 * 
	 */
	public UserDto() {
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
	public UserDto(Date createdDate, Date lastModifiedDate, String fName, String lName, String email, String mobile) {
		super(createdDate, lastModifiedDate, fName, lName, email, mobile);
		// TODO Auto-generated constructor stub
	}
}
