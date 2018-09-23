package com.chulan.schoolmanagement.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chulan.schoolmanagement.util.CaptureErrorString;

/**
 * @author chulan
 * Controller class to show the login screen
 */
@Controller
public class HomeController {

	//to load the login screen
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String initStart(ModelMap model) {
		
		try {
			return "user/login";
		} catch (Exception e) {
			return CaptureErrorString.catchedErrorMsg(e);
		}
	}
	
	//to load the Error screen
	@RequestMapping(value="/error/list/{msg}",method=RequestMethod.GET)
	public String error(@PathVariable("msg") String msg,Map<String, Object> map) {
		map.put("errorMsg", msg);
		return "error/list";
	}
}
