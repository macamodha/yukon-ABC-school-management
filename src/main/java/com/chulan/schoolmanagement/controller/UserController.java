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
import org.springframework.web.bind.annotation.RequestParam;

import com.chulan.schoolmanagement.model.User;
import com.chulan.schoolmanagement.service.UserService;
import com.chulan.schoolmanagement.util.CaptureErrorString;

/**
 * @author chulan - Controller class of the User Model with Request mappings to
 *         methods
 */
@Controller
@RequestMapping("/user/")
public class UserController {

	@Autowired
	UserService userService;

	// register user load screen using get method
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Map<String, Object> map) {

		try {
			return userService.register(map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// create user using post method
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("user") User user, BindingResult result, Map<String, Object> map) {

		try {
			return userService.create(result, user, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Show details of a user
	@RequestMapping(value = "/details/{userId}", method = RequestMethod.GET)
	public String details(@PathVariable("userId") Long uId, Map<String, Object> map) {

		try {
			return userService.details(map, uId);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Display all the users
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Map<String, Object> map) {

		try {
			return userService.getAll(map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Edit selected user load screen using get method
	@RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
	public String edit(@PathVariable("userId") Long usrId, Map<String, Object> map) {

		try {
			return userService.edit(map, usrId);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Update selected user using post method
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("user") User user, BindingResult result, Map<String, Object> map) {

		try {
			return userService.update(result, user, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Delete selected user
	@RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
	public String delete(@PathVariable("userId") Long userId, Map<String, Object> map) {

		try {
			return userService.delete(map, userId);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// User Login
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("psw") String psw, Map<String, Object> map) {

		try {
			return userService.login(email, psw, map);
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}

	// Just to show an empty page
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Map<String, Object> map) {

		try {
			return "/user/home";
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}
}
