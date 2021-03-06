package com.chulan.schoolmanagement.dto;

import java.util.Date;

import com.chulan.schoolmanagement.dto.CreatedAndModifiedDateDto;


/**
 * @author chulan
 * Course Data Transfer Object
 */

public class CourseDto extends CreatedAndModifiedDateDto{
	
	private Long crsId;
	private String cName;
	private String status;
	private SemesterDto semester;
	private TeacherDto teacher;

	/**
	 * @return the crsId
	 */
	public Long getCrsId() {
		return crsId;
	}

	/**
	 * @param crsId the crsId to set
	 */
	public void setCrsId(Long crsId) {
		this.crsId = crsId;
	}

	/**
	 * @return the cName
	 */
	public String getcName() {
		return cName;
	}

	/**
	 * @param cName the cName to set
	 */
	public void setcName(String cName) {
		this.cName = cName;
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
	 * @return the semester
	 */
	public SemesterDto getSemester() {
		return semester;
	}

	/**
	 * @param semester the semester to set
	 */
	public void setSemester(SemesterDto semester) {
		this.semester = semester;
	}

	/**
	 * @return the teacher
	 */
	public TeacherDto getTeacher() {
		return teacher;
	}

	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(TeacherDto teacher) {
		this.teacher = teacher;
	}

	/**
	 * @param createdDate
	 * @param lastModifiedDate
	 * @param crsId
	 * @param cName
	 * @param status
	 * @param semester
	 * @param teacher
	 */
	public CourseDto(Date createdDate, Date lastModifiedDate, Long crsId, String cName, String status,
			SemesterDto semester, TeacherDto teacher) {
		super(createdDate, lastModifiedDate);
		this.crsId = crsId;
		this.cName = cName;
		this.status = status;
		this.semester = semester;
		this.teacher = teacher;
	}

	/**
	 * 
	 */
	public CourseDto() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param createdDate
	 * @param lastModifiedDate
	 */
	public CourseDto(Date createdDate, Date lastModifiedDate) {
		super(createdDate, lastModifiedDate);
		// TODO Auto-generated constructor stub
	}
	
}
