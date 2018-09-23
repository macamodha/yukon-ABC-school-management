package com.chulan.schoolmanagement.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chulan.schoolmanagement.dao.EnrollStudentDao;
import com.chulan.schoolmanagement.model.Course;
import com.chulan.schoolmanagement.model.EnrollStudent;

/**
 * @author chulan
 * Data Access Object implementation class of the EnrollStudent
 */
@Transactional
@Repository("enrollStudentDao")
public class EnrollStudentDaoImpl implements EnrollStudentDao {

	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(EnrollStudent enrollStudent) {
		currentSession().save(enrollStudent);

	}

	@Override
	public void update(EnrollStudent enrollStudent) {
		currentSession().update(enrollStudent);

	}

	@Override
	public EnrollStudent find(Long enrollStudentId) {
		return currentSession().get(EnrollStudent.class, enrollStudentId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EnrollStudent> getAll() {
		return currentSession().createQuery("from EnrollStudent").getResultList();
	}

	@Override
	public void delete(EnrollStudent enrollStudent) {
		currentSession().delete(enrollStudent);
	}

	@Override
	public List<Course> getDistinctActiveCourses() {
		
		@SuppressWarnings("deprecation")
		Criteria criteria = currentSession().createCriteria(EnrollStudent.class);
		criteria.setProjection(Projections.distinct(Projections.projectionList()
				.add(Projections.property("course"))));
		
		@SuppressWarnings("unchecked")
		List<Course> cList = criteria.list(); 
		return cList;
	}

}
