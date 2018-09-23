package com.chulan.schoolmanagement.dao;

import java.util.List;

import com.chulan.schoolmanagement.model.User;

/**
 * @author chulan 
 * Data Access Object interface of the User
 */
public interface UserDao {

	public void create(User user);

	public void update(User user);

	public void delete(User user);

	public User find(Long userId);

	public List<User> getAll();
}
