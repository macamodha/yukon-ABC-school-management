package com.chulan.schoolmanagement.service;

import java.util.Map;

import org.springframework.validation.BindingResult;

import com.chulan.schoolmanagement.model.Teacher;

/**
 * @author chulan 
 * Service interface of the the Teacher
 */
public interface TeacherService {

	public String register(Map<String, Object> map);
	
	public String create(Teacher teacher, BindingResult result, Map<String, Object> map);
	
	public String details(Long tId, Map<String, Object> map);
	
	public String edit(Long teachId, Map<String, Object> map);
	
	public String update(Teacher teacher, BindingResult result, Map<String, Object> map);

	public String delete(Long teachId, Map<String, Object> map);

	public Teacher find(Long teachId);

	public String getAll(Map<String, Object> map);
}
