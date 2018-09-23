package com.chulan.schoolmanagement.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;


/**
 * @author chulan
 * Enroll Student to the course Model
 */

@Entity
@Table(name="course_enroll_student")
public class EnrollStudent extends CreatedAndModifiedDate{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long enrId;
	
	private float finalMarks;
	
	@Size(min=1, max=1, message="Course Status cannot be blank.")
	private String status;
	
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST },fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="crs_id")
	private Course course;
	
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST },fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="stu_id")
	private Student student;

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
	public Course getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
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
	public EnrollStudent(Date createdDate, Date lastModifiedDate, Long enrId, float finalMarks, String status,
			Course course, Student student) {
		super(createdDate, lastModifiedDate);
		this.enrId = enrId;
		this.finalMarks = finalMarks;
		this.status = status;
		this.course = course;
		this.student = student;
	}

	/**
	 * 
	 */
	public EnrollStudent() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param createdDate
	 * @param lastModifiedDate
	 */
	public EnrollStudent(Date createdDate, Date lastModifiedDate) {
		super(createdDate, lastModifiedDate);
		// TODO Auto-generated constructor stub
	}
	

}
