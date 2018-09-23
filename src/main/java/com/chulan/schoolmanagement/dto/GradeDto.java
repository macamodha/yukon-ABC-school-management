package com.chulan.schoolmanagement.dto;

import java.util.Date;

import com.chulan.schoolmanagement.dto.CreatedAndModifiedDateDto;

/**
 * @author chulan
 * Grade Data Transfer Object
 */

public class GradeDto extends CreatedAndModifiedDateDto{

	private Long grdId;
	private String gName;
	private float upperValue;
	private float lowerValue;
	private String gradeType;

	/**
	 * @return the grdId
	 */
	public Long getGrdId() {
		return grdId;
	}

	/**
	 * @param grdId the grdId to set
	 */
	public void setGrdId(Long grdId) {
		this.grdId = grdId;
	}

	/**
	 * @return the gName
	 */
	public String getgName() {
		return gName;
	}

	/**
	 * @param gName the gName to set
	 */
	public void setgName(String gName) {
		this.gName = gName;
	}

	/**
	 * @return the upperValue
	 */
	public float getUpperValue() {
		return upperValue;
	}

	/**
	 * @param upperValue the upperValue to set
	 */
	public void setUpperValue(float upperValue) {
		this.upperValue = upperValue;
	}

	/**
	 * @return the lowerValue
	 */
	public float getLowerValue() {
		return lowerValue;
	}

	/**
	 * @param lowerValue the lowerValue to set
	 */
	public void setLowerValue(float lowerValue) {
		this.lowerValue = lowerValue;
	}

	/**
	 * @return the gradeType
	 */
	public String getGradeType() {
		return gradeType;
	}

	/**
	 * @param gradeType the gradeType to set
	 */
	public void setGradeType(String gradeType) {
		this.gradeType = gradeType;
	}

	/**
	 * @param createdDate
	 * @param lastModifiedDate
	 * @param grdId
	 * @param gName
	 * @param upperValue
	 * @param lowerValue
	 * @param gradeType
	 */
	public GradeDto(Date createdDate, Date lastModifiedDate, Long grdId, String gName, float upperValue,
			float lowerValue, String gradeType) {
		super(createdDate, lastModifiedDate);
		this.grdId = grdId;
		this.gName = gName;
		this.upperValue = upperValue;
		this.lowerValue = lowerValue;
		this.gradeType = gradeType;
	}

	/**
	 * 
	 */
	public GradeDto() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param createdDate
	 * @param lastModifiedDate
	 */
	public GradeDto(Date createdDate, Date lastModifiedDate) {
		super(createdDate, lastModifiedDate);
		// TODO Auto-generated constructor stub
	}
	
	
}
