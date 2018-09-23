package com.chulan.schoolmanagement.service;

import java.util.Map;

import org.springframework.validation.BindingResult;

import com.chulan.schoolmanagement.model.User;

/**
 * @author chulan 
 * Service interface of the the User
 */
public interface UserService {

	public String register(Map<String, Object> map);
	
	public String create(BindingResult result,User user,Map<String, Object> map);
	
	public String details(Map<String, Object> map, Long uId);
	
	public String edit(Map<String, Object> map, Long uId);

	public String update(BindingResult result,User user,Map<String, Object> map);

	public String delete(Map<String, Object> map, Long uId);

	public User find(Long userId);

	public String getAll(Map<String, Object> map);
	
	public String login(String email,String psw,Map<String, Object> map );
}
