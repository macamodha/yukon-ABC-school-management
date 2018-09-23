package com.chulan.schoolmanagement.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chulan.schoolmanagement.service.ReportService;
import com.chulan.schoolmanagement.util.CaptureErrorString;

/**
 * @author chulan - Controller class of the Reports
 */
@Controller
@RequestMapping("/report/")
public class ReportController {

	@Autowired
	ReportService reportService;

	// Display all the available courses to generate reports
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Map<String, Object> map) {

		try {
			return reportService.getAll(map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// generate report
	@RequestMapping(value = "/generate/{crsId}", method = RequestMethod.GET)
	public String details(@PathVariable("crsId") Long cId, Map<String, Object> map, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			return reportService.details(cId, map, request, response);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}
}
