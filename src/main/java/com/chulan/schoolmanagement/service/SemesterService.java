package com.chulan.schoolmanagement.service;

import java.util.Map;

import org.springframework.validation.BindingResult;

import com.chulan.schoolmanagement.model.Semester;

/**
 * @author chulan 
 * Service interface of the the Semester
 */
public interface SemesterService {

	public String register(Map<String, Object> map);
	
	public String create(Semester semester, BindingResult result, Map<String, Object> map);
	
	public String details(Long sId, Map<String, Object> map);
	
	public String edit(Long sId, Map<String, Object> map);

	public String update(Semester semester, BindingResult result, Map<String, Object> map);

	public String delete(Long semId, Map<String, Object> map);

	public Semester find(Long semId);

	public String getAll(Map<String, Object> map);
}
