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
 * Course Model
 */

@Entity
@Table(name="course")
public class Course extends CreatedAndModifiedDate{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long crsId;
	
	@Size(min=2, max=15, message="Course Name should be between 2-15 characters.")
	private String cName;
	
	@Size(min=1, max=1, message="Status cannot be blank.")
	private String status;
	
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST },fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="sem_id")
	private Semester semester;
	
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST },fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="teacher_id")
	private Teacher teacher;

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
	public Semester getSemester() {
		return semester;
	}

	/**
	 * @param semester the semester to set
	 */
	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	/**
	 * @return the teacher
	 */
	public Teacher getTeacher() {
		return teacher;
	}

	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(Teacher teacher) {
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
	public Course(Date createdDate, Date lastModifiedDate, Long crsId, String cName, String status, Semester semester,
			Teacher teacher) {
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
	public Course() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param createdDate
	 * @param lastModifiedDate
	 */
	public Course(Date createdDate, Date lastModifiedDate) {
		super(createdDate, lastModifiedDate);
		// TODO Auto-generated constructor stub
	}
	
	
}
