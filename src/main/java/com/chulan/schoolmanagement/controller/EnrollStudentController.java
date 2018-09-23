package com.chulan.schoolmanagement.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chulan.schoolmanagement.model.EnrollStudent;
import com.chulan.schoolmanagement.service.EnrollStudentService;
import com.chulan.schoolmanagement.util.CaptureErrorString;

/**
 * @author chulan - Controller class of the EnrollStudent Model with Request
 *         mappings to methods
 */
@Controller
@RequestMapping("/enrollStudent/")
public class EnrollStudentController {

	@Autowired
	EnrollStudentService enrollStudentService;

	// create enrollStudent load screen using get method
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Map<String, Object> map) {

		try {
			return enrollStudentService.register(map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// create enrollStudent using post method
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("enrollStudent") EnrollStudent enrollStudent, BindingResult result,
			Map<String, Object> map) {

		try {
			return enrollStudentService.create(enrollStudent, result, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Show details of a enrollStudent
	@RequestMapping(value = "/details/{enrollStudentId}", method = RequestMethod.GET)
	public String details(@PathVariable("enrollStudentId") Long esId, Map<String, Object> map) {

		try {
			return enrollStudentService.details(esId, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Display all the enrollStudents
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Map<String, Object> map) {

		try {
			return enrollStudentService.getAll(map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Edit selected enrollStudent load screen using get method
	@RequestMapping(value = "/edit/{enrollStudentId}", method = RequestMethod.GET)
	public String edit(@PathVariable("enrollStudentId") Long esId, Map<String, Object> map) {

		try {
			return enrollStudentService.edit(esId, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Update selected enrollStudent using post method
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("enrollStudent") EnrollStudent enrollStudent, BindingResult result,
			Map<String, Object> map) {

		try {
			return enrollStudentService.update(enrollStudent, result, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Delete selected enrollStudent
	@RequestMapping(value = "/delete/{enrollStudentId}", method = RequestMethod.GET)
	public String delete(@PathVariable("enrollStudentId") Long enrollStudentId, Map<String, Object> map) {

		try {
			return enrollStudentService.delete(enrollStudentId, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}
}
