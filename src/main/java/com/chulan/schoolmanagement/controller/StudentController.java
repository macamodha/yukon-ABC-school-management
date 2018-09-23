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

import com.chulan.schoolmanagement.model.Student;
import com.chulan.schoolmanagement.service.StudentService;
import com.chulan.schoolmanagement.util.CaptureErrorString;

/**
 * @author chulan - Controller class of the Student Model with Request mappings
 *         to methods
 */
@Controller
@RequestMapping("/student/")
public class StudentController {

	@Autowired
	StudentService studentService;

	// create student load screen using get method
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Map<String, Object> map) {

		try {
			return studentService.register(map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// create student using post method
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("student") Student student, BindingResult result,
			Map<String, Object> map) {

		try {
			return studentService.create(student, result, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Show details of a student
	@RequestMapping(value = "/details/{stuId}", method = RequestMethod.GET)
	public String details(@PathVariable("stuId") Long sId, Map<String, Object> map) {

		try {
			return studentService.details(sId, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Display all the students
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Map<String, Object> map) {

		try {
			return studentService.getAll(map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}

	}

	// Edit selected student load screen using get method
	@RequestMapping(value = "/edit/{stuId}", method = RequestMethod.GET)
	public String edit(@PathVariable("stuId") Long stuId, Map<String, Object> map) {

		try {
			return studentService.edit(stuId, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Update selected student using post method
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("student") Student student, BindingResult result,
			Map<String, Object> map) {

		try {
			return studentService.update(student, result, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Delete selected student
	@RequestMapping(value = "/delete/{stuId}", method = RequestMethod.GET)
	public String delete(@PathVariable("stuId") Long stuId, Map<String, Object> map) {

		try {
			return studentService.delete(stuId, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}
}
