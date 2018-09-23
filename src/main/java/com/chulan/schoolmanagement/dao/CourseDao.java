package com.chulan.schoolmanagement.dao;

import java.util.List;

import com.chulan.schoolmanagement.model.Course;

/**
 * @author chulan
 * Data Access Object interface of the Course
 */
public interface CourseDao {

	public void create(Course course);

	public void update(Course course);

	public void delete(Course course);

	public Course find(Long courseDto);

	public List<Course> getAll();
}
