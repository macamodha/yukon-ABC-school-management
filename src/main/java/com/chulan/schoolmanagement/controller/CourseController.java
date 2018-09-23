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

import com.chulan.schoolmanagement.model.Course;
import com.chulan.schoolmanagement.service.CourseService;
import com.chulan.schoolmanagement.util.CaptureErrorString;

/**
 * @author chulan - Controller class of the Course Model with Request mappings
 *         to methods
 */
@Controller
@RequestMapping("/course/")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	// create course load screen using get method
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Map<String, Object> map) {

		try {
			return courseService.register(map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}

	}

	// create course using post method
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("course") Course course, BindingResult result,
			Map<String, Object> map) {

		try {
			
			return courseService.create(course, result, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Show details of a course
	@RequestMapping(value = "/details/{courseId}", method = RequestMethod.GET)
	public String details(@PathVariable("courseId") Long cId, Map<String, Object> map) {
		
		try {
			return courseService.details(cId, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Display all the courses
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Map<String, Object> map) {
		
		try {
			return courseService.getAll(map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Edit selected course load screen using get method
	@RequestMapping(value = "/edit/{courseId}", method = RequestMethod.GET)
	public String edit(@PathVariable("courseId") Long cId, Map<String, Object> map) {
		
		try {
			return courseService.edit(cId, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Update selected course using post method
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("course") Course course, BindingResult result,
			Map<String, Object> map) {
		
		try {
			return courseService.update(course, result, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Delete selected course
	@RequestMapping(value = "/delete/{courseId}", method = RequestMethod.GET)
	public String delete(@PathVariable("courseId") Long courseId, Map<String, Object> map) {
		
		try {
			return courseService.delete(courseId, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}
}
