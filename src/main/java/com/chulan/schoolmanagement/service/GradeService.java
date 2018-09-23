package com.chulan.schoolmanagement.service;


import java.util.Map;

import org.springframework.validation.BindingResult;

import com.chulan.schoolmanagement.model.Grade;

/**
 * @author chulan 
 * Service interface of the the Grade
 */
public interface GradeService {

	public String register(Map<String, Object> map);
	
	public String create(Grade grade, BindingResult result, Map<String, Object> map);
	
	public String details(Long gId, Map<String, Object> map);
	
	public String edit(Long gId, Map<String, Object> map);

	public String update(Grade grade, BindingResult result, Map<String, Object> map);

	public String delete(Long gradeId, Map<String, Object> map);

	public Grade find(Long gradeId);

	public String getAll(Map<String, Object> map);
}
