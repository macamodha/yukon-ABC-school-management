package com.chulan.schoolmanagement.model;

import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * @author chulan
 * Created date and last modified date to apply in every Model using inheritance
 */
@MappedSuperclass
public abstract class CreatedAndModifiedDate {

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
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
	public CreatedAndModifiedDate(Date createdDate, Date lastModifiedDate) {
		super();
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}

	/**
	 * 
	 */
	public CreatedAndModifiedDate() {
		// TODO Auto-generated constructor stub
	}
	
	
}
