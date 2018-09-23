package com.chulan.schoolmanagement.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.chulan.schoolmanagement.dao.UserDao;
import com.chulan.schoolmanagement.model.User;

/**
 * @author chulan
 * Data Access Object implementation class of the User
 */
@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired 
	SessionFactory sessionFactory;
	
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(User user) {
		currentSession().save(user);
	}

	@Override
	public void update(User user) {
		currentSession().update(user);
	}

	@Override
	public void delete(User user) {
		currentSession().delete(user);
	}

	@Override
	public User find(Long userId) {
		return currentSession().get(User.class, userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		return currentSession().createQuery("from User").getResultList();
	}
}
