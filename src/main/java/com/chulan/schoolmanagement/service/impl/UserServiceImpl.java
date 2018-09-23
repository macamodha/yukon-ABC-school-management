package com.chulan.schoolmanagement.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.chulan.schoolmanagement.dao.UserDao;
import com.chulan.schoolmanagement.model.User;
import com.chulan.schoolmanagement.service.UserService;

/**
 * @author chulan Service implementation class of the User
 */
@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public String register(Map<String, Object> map) {

		map.put("user", new User());
		return "user/register";
	}

	@Override
	public String create(BindingResult result, User user, Map<String, Object> map) {

		// Model validation for errors
		if (result.hasErrors()) {
			return "user/register";
		}

		// set created and last modified date
		user.setCreatedDate(java.util.Calendar.getInstance().getTime());
		user.setLastModifiedDate(java.util.Calendar.getInstance().getTime());

		userDao.create(user);
		return "redirect:/user/list";
	}

	@Override
	public String details(Map<String, Object> map, Long uId) {

		User user = find(uId);

		// assign user details into a map object
		map.put("fName", user.getfName());
		map.put("lName", user.getlName());
		map.put("email", user.getEmail());
		map.put("mobile", user.getMobile());
		map.put("createdDate", user.getCreatedDate());
		map.put("lastModifiedDate", user.getLastModifiedDate());

		return "user/details";
	}

	@Override
	public String edit(Map<String, Object> map, Long uId) {

		User user = find(uId);
		map.put("user", user);

		return "user/edit";
	}

	@Override
	public String update(BindingResult result, User user, Map<String, Object> map) {

		// Model validation for errors
		if (result.hasErrors()) {
			return "user/edit";
		}

		User u = find(user.getUserId());
		// set updating fields
		user.setCreatedDate(u.getCreatedDate());
		user.setLastModifiedDate(java.util.Calendar.getInstance().getTime());

		userDao.update(user);
		return "redirect:/user/list";
	}

	@Override
	public String delete(Map<String, Object> map, Long uId) {
		userDao.delete(find(uId));
		return "redirect:/user/list";
	}

	@Override
	public User find(Long userId) {
		return userDao.find(userId);
	}

	@Override
	public String getAll(Map<String, Object> map) {

		map.put("userList", userDao.getAll());
		return "user/list";
	}

	public String login(String email, String psw, Map<String, Object> map) {

		for (User u : userDao.getAll()) {
			if (u.getEmail().equals(email) && u.getPsw().equals(psw)) {
				return "redirect:/user/home";
			}

		}

		map.put("message", "Invalid Email or Password provided.");
		return "/user/login";
	}

}