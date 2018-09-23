package com.chulan.schoolmanagement.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chulan.schoolmanagement.dao.SemesterDao;
import com.chulan.schoolmanagement.model.Semester;

/**
 * @author chulan
 * Data Access Object implementation class of the Semester
 */
@Transactional
@Repository("semesterDao")
public class SemesterDaoImpl implements SemesterDao {

	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(Semester semester) {
		currentSession().save(semester);

	}

	@Override
	public void update(Semester semester) {
		currentSession().update(semester);

	}

	@Override
	public void delete(Semester semester) {
		currentSession().delete(semester);

	}

	@Override
	public Semester find(Long semId) {
		return currentSession().get(Semester.class, semId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Semester> getAll() {
		return currentSession().createQuery("from Semester").getResultList();
	}

}
