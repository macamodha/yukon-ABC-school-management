package com.chulan.schoolmanagement.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chulan.schoolmanagement.dao.GradeDao;
import com.chulan.schoolmanagement.model.Grade;

/**
 * @author chulan
 * Data Access Object implementation class of the Grade
 */
@Transactional
@Repository("gradeDao")
public class GradeDaoImpl implements GradeDao {

	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(Grade grade) {
		currentSession().save(grade);

	}

	@Override
	public void update(Grade grade) {
		currentSession().update(grade);

	}

	@Override
	public void delete(Grade grade) {
		currentSession().delete(grade);

	}

	@Override
	public Grade find(Long gradeId) {
		return currentSession().get(Grade.class, gradeId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Grade> getAll() {
		return currentSession().createQuery("from Grade").getResultList();
	}

}
