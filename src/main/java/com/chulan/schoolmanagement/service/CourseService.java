package com.chulan.schoolmanagement.service;

import java.util.Map;

import org.springframework.validation.BindingResult;

import com.chulan.schoolmanagement.model.Course;

/**
 * @author chulan 
 * Service interface of the the Course
 */
public interface CourseService {

	public String register(Map<String, Object> map);
	
	public String create(Course course, BindingResult result, Map<String, Object> map);
	
	public String details(Long cId, Map<String, Object> map);

	public String edit(Long cId, Map<String, Object> map);
	
	public String update(Course course, BindingResult result, Map<String, Object> map);

	public String delete(Long courseId,Map<String, Object> map);

	public Course find(Long courseId);

	public String getAll(Map<String, Object> map);
}
