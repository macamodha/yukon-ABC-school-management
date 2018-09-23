package com.chulan.schoolmanagement.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chulan 
 * Service interface of the the Reports
 */
public interface ReportService {

	public String getAll(Map<String, Object> map);
	
	public String details(Long cId,Map<String, Object> map,HttpServletRequest request, HttpServletResponse response);
	
}
