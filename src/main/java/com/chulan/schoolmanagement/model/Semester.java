package com.chulan.schoolmanagement.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Size;

/**
 * @author chulan
 * Semester Model
 */

@Entity
@Table(name="semester")
public class Semester extends CreatedAndModifiedDate{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long semId;
	
	@Size(min=2, max=10, message="Semester should be between 2-10 characters.")
	private String semDescr;
	
	@Size(min=1, max=1, message="Invalid Status Selected")
	private String status;

	/**
	 * @return the semId
	 */
	public Long getSemId() {
		return semId;
	}

	/**
	 * @param semId the semId to set
	 */
	public void setSemId(Long semId) {
		this.semId = semId;
	}

	/**
	 * @return the semDescr
	 */
	public String getSemDescr() {
		return semDescr;
	}

	/**
	 * @param semDescr the semDescr to set
	 */
	public void setSemDescr(String semDescr) {
		this.semDescr = semDescr;
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
	 * @param semId
	 * @param semDescr
	 * @param status
	 */
	public Semester(Date createdDate, Date lastModifiedDate, Long semId, String semDescr, String status) {
		super(createdDate, lastModifiedDate);
		this.semId = semId;
		this.semDescr = semDescr;
		this.status = status;
	}

	/**
	 * 
	 */
	public Semester() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param createdDate
	 * @param lastModifiedDate
	 */
	public Semester(Date createdDate, Date lastModifiedDate) {
		super(createdDate, lastModifiedDate);
		// TODO Auto-generated constructor stub
	}
	
}
