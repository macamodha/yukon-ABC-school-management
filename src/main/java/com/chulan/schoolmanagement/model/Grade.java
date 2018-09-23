package com.chulan.schoolmanagement.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author chulan
 * Grade model to give a grade according to the final marks
 */
@Entity
@Table(name="grade")
public class Grade extends CreatedAndModifiedDate{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long grdId;
	
	@Size(min=1, max=1, message="Grade Should be a one character.")
	private String gName;
	
	@NotNull(message="Upper mark value cannot be blank.")
	private float upperValue;
	
	@NotNull(message="Lower mark value cannot be blank.")
	private float lowerValue;
	
	@Size(min=1, max=1, message="Grade Type cannot be blank.")
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
	public Grade(Date createdDate, Date lastModifiedDate, Long grdId, String gName, float upperValue, float lowerValue,
			String gradeType) {
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
	public Grade() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param createdDate
	 * @param lastModifiedDate
	 */
	public Grade(Date createdDate, Date lastModifiedDate) {
		super(createdDate, lastModifiedDate);
		// TODO Auto-generated constructor stub
	}
	
}
