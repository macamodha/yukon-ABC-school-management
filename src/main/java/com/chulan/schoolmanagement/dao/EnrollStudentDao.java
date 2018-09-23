package com.chulan.schoolmanagement.dao;

import java.util.List;

import com.chulan.schoolmanagement.model.Course;
import com.chulan.schoolmanagement.model.EnrollStudent;

/**
 * @author chulan
 * Data Access Object interface of the Enroll Student
 */
public interface EnrollStudentDao {

	public void create(EnrollStudent enrollStudent);

	public void update(EnrollStudent enrollStudent);
	
	public void delete(EnrollStudent enrollStudent);

	public EnrollStudent find(Long enrollStudentId);

	public List<EnrollStudent> getAll();
	
	public List<Course> getDistinctActiveCourses();
}
