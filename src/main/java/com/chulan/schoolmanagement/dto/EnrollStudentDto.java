package com.chulan.schoolmanagement.dto;

import java.util.Date;

import com.chulan.schoolmanagement.dto.CreatedAndModifiedDateDto;


/**
 * @author chulan
 * Enroll-Student Data Transfer Object
 */

public class EnrollStudentDto extends CreatedAndModifiedDateDto{
	
	private Long enrId;
	private float finalMarks;
	private String status;
	private CourseDto course;
	private StudentDto student;

	/**
	 * @return the enrId
	 */
	public Long getEnrId() {
		return enrId;
	}

	/**
	 * @param enrId the enrId to set
	 */
	public void setEnrId(Long enrId) {
		this.enrId = enrId;
	}

	/**
	 * @return the finalMarks
	 */
	public float getFinalMarks() {
		return finalMarks;
	}

	/**
	 * @param finalMarks the finalMarks to set
	 */
	public void setFinalMarks(float finalMarks) {
		this.finalMarks = finalMarks;
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
	 * @return the course
	 */
	public CourseDto getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(CourseDto course) {
		this.course = course;
	}

	/**
	 * @return the student
	 */
	public StudentDto getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(StudentDto student) {
		this.student = student;
	}

	/**
	 * 
	 */
	public EnrollStudentDto() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param createdDate
	 * @param lastModifiedDate
	 */
	public EnrollStudentDto(Date createdDate, Date lastModifiedDate) {
		super(createdDate, lastModifiedDate);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param createdDate
	 * @param lastModifiedDate
	 * @param enrId
	 * @param finalMarks
	 * @param status
	 * @param course
	 * @param student
	 */
	public EnrollStudentDto(Date createdDate, Date lastModifiedDate, Long enrId, float finalMarks, String status,
			CourseDto course, StudentDto student) {
		super(createdDate, lastModifiedDate);
		this.enrId = enrId;
		this.finalMarks = finalMarks;
		this.status = status;
		this.course = course;
		this.student = student;
	}
}
