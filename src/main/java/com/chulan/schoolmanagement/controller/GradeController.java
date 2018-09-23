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

import com.chulan.schoolmanagement.model.Grade;
import com.chulan.schoolmanagement.service.GradeService;
import com.chulan.schoolmanagement.util.CaptureErrorString;

/**
 * @author chulan - Controller class of the Grade Model with Request mappings to
 *         methods
 */
@Controller
@RequestMapping("/grade/")
public class GradeController {

	@Autowired
	GradeService gradeService;

	// create grade load screen using get method
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Map<String, Object> map) {

		try {
			return gradeService.register(map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// create grade using post method
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("grade") Grade grade, BindingResult result, Map<String, Object> map) {

		try {
			return gradeService.create(grade, result, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Show details of a grade
	@RequestMapping(value = "/details/{grdId}", method = RequestMethod.GET)
	public String details(@PathVariable("grdId") Long gId, Map<String, Object> map) {

		try {
			return gradeService.details(gId, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Display all the grades
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Map<String, Object> map) {

		try {
			return gradeService.getAll(map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Edit selected grade load screen using get method
	@RequestMapping(value = "/edit/{grdId}", method = RequestMethod.GET)
	public String edit(@PathVariable("grdId") Long grdId, Map<String, Object> map) {

		try {
			return gradeService.edit(grdId, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Update selected grade using post method
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("grade") Grade grade, BindingResult result, Map<String, Object> map) {

		try {
			return gradeService.update(grade, result, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Delete selected grade
	@RequestMapping(value = "/delete/{grdId}", method = RequestMethod.GET)
	public String delete(@PathVariable("grdId") Long grdId, Map<String, Object> map) {

		try {
			return gradeService.delete(grdId, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}
}
