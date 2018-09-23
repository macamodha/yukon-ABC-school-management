package com.chulan.schoolmanagement.util;

public class CaptureErrorString {

	// errorMessageWithUrl
	public static String catchedErrorMsg(Exception e) {
		return "redirect:/error/list/" +e.getMessage();
	}
}
