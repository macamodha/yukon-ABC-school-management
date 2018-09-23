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

import com.chulan.schoolmanagement.model.Semester;
import com.chulan.schoolmanagement.service.SemesterService;
import com.chulan.schoolmanagement.util.CaptureErrorString;

/**
 * @author chulan - Controller class of the Semester Model with Request mappings
 *         to methods
 */
@Controller
@RequestMapping("/semester/")
public class SemesterController {

	@Autowired
	SemesterService semesterService;
	
	// create semester load screen using get method
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Map<String, Object> map) {

		try {

			return semesterService.register(map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// create semester using post method
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("semester") Semester semester, BindingResult result,
			Map<String, Object> map) {

		try {

			return semesterService.create(semester, result, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Show details of a semester
	@RequestMapping(value = "/details/{semId}", method = RequestMethod.GET)
	public String details(@PathVariable("semId") Long sId, Map<String, Object> map) {

		try {

			return semesterService.details(sId, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Display all the semesters
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Map<String, Object> map) {

		try {

			return semesterService.getAll(map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Edit selected semester load screen using get method
	@RequestMapping(value = "/edit/{semId}", method = RequestMethod.GET)
	public String edit(@PathVariable("semId") Long semId, Map<String, Object> map) {

		try {

			return semesterService.edit(semId, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Update selected semester using post method
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("semester") Semester semester, BindingResult result,
			Map<String, Object> map) {

		try {

			return semesterService.update(semester, result, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Delete selected semester
	@RequestMapping(value = "/delete/{semId}", method = RequestMethod.GET)
	public String delete(@PathVariable("semId") Long semId, Map<String, Object> map) {

		try {

			return semesterService.delete(semId, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}
}
