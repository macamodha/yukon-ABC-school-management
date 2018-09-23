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

import com.chulan.schoolmanagement.model.Teacher;
import com.chulan.schoolmanagement.service.TeacherService;
import com.chulan.schoolmanagement.util.CaptureErrorString;

/**
 * @author chulan - Controller class of the Teacher Model with Request mappings
 *         to methods
 */
@Controller
@RequestMapping("/teacher/")
public class TeacherController {

	@Autowired
	TeacherService teacherService;

	// create teacher load screen using get method
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Map<String, Object> map) {

		try {
			return teacherService.register(map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// create teacher using post method
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("teacher") Teacher teacher, BindingResult result,
			Map<String, Object> map) {

		try {
			return teacherService.create(teacher, result, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Show details of a teacher
	@RequestMapping(value = "/details/{teachId}", method = RequestMethod.GET)
	public String details(@PathVariable("teachId") Long tId, Map<String, Object> map) {

		try {
			return teacherService.details(tId, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Display all the teachers
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Map<String, Object> map) {

		try {
			return teacherService.getAll(map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Edit selected teacher load screen using get method
	@RequestMapping(value = "/edit/{teachId}", method = RequestMethod.GET)
	public String edit(@PathVariable("teachId") Long teachId, Map<String, Object> map) {

		try {
			return teacherService.edit(teachId, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Update selected teacher using post method
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("teacher") Teacher teacher, BindingResult result,
			Map<String, Object> map) {

		try {
			return teacherService.update(teacher, result, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Delete selected teacher
	@RequestMapping(value = "/delete/{teachId}", method = RequestMethod.GET)
	public String delete(@PathVariable("teachId") Long teachId, Map<String, Object> map) {

		try {
			return teacherService.delete(teachId, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}
}
