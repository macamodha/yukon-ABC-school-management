package com.chulan.schoolmanagement.service;

import java.util.Map;

import org.springframework.validation.BindingResult;

import com.chulan.schoolmanagement.model.Student;

/**
 * @author chulan 
 * Service interface of the the Student
 */
public interface StudentService {

	public String register(Map<String, Object> map);
	
	public String create(Student student, BindingResult result, Map<String, Object> map);
	
	public String details(Long sId, Map<String, Object> map);

	public String edit(Long stuId, Map<String, Object> map);
	
	public String update(Student student, BindingResult result, Map<String, Object> map);

	public String delete(Long sId, Map<String, Object> map);

	public Student find(Long stuId);

	public String getAll(Map<String, Object> map);
}
