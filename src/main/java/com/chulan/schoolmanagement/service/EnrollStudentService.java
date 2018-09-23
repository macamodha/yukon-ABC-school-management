package com.chulan.schoolmanagement.service;

import java.util.Map;

import org.springframework.validation.BindingResult;

import com.chulan.schoolmanagement.model.EnrollStudent;

/**
 * @author chulan 
 * Service interface of the the EnrollStudent
 */
public interface EnrollStudentService {

	public String register(Map<String, Object> map);
	
	public String create(EnrollStudent enrollStudent, BindingResult result, Map<String, Object> map);

	public String details(Long esId, Map<String, Object> map);
	
	public String edit(Long esId, Map<String, Object> map);
	
	public String update(EnrollStudent enrollStudent, BindingResult result, Map<String, Object> map);
	
	public String delete(Long esId, Map<String, Object> map);

	public EnrollStudent find(Long enrollStudentId);

	public String getAll(Map<String, Object> map);
	
	public void sendMail(EnrollStudent enrollStudent);
}
