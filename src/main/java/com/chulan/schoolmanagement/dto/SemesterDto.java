package com.chulan.schoolmanagement.dto;

import java.util.Date;

import com.chulan.schoolmanagement.dto.CreatedAndModifiedDateDto;

/**
 * @author chulan
 * Semester Data Transfer Object
 */

public class SemesterDto extends CreatedAndModifiedDateDto{
	
	private Long semId;
	private String semDescr;
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
	public SemesterDto(Date createdDate, Date lastModifiedDate, Long semId, String semDescr, String status) {
		super(createdDate, lastModifiedDate);
		this.semId = semId;
		this.semDescr = semDescr;
		this.status = status;
	}

	/**
	 * 
	 */
	public SemesterDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param createdDate
	 * @param lastModifiedDate
	 */
	public SemesterDto(Date createdDate, Date lastModifiedDate) {
		super(createdDate, lastModifiedDate);
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
