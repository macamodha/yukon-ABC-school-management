package com.chulan.schoolmanagement.dto;

import java.util.Date;

import javax.persistence.MappedSuperclass;


/**
 * @author chulan
 * Created date and last modified date to apply in every Model using inheritance
 */
@MappedSuperclass
public abstract class CreatedAndModifiedDateDto {

	private Date createdDate;
	private Date lastModifiedDate;

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the lastModifiedDate
	 */
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	/**
	 * @param lastModifiedDate the lastModifiedDate to set
	 */
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	/**
	 * @param createdDate
	 * @param lastModifiedDate
	 */
	public CreatedAndModifiedDateDto(Date createdDate, Date lastModifiedDate) {
		super();
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}

	/**
	 * 
	 */
	public CreatedAndModifiedDateDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
