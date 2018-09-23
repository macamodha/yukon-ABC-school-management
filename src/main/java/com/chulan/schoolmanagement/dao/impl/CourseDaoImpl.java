package com.chulan.schoolmanagement.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chulan.schoolmanagement.dao.CourseDao;
import com.chulan.schoolmanagement.model.Course;

/**
 * @author chulan
 * Data Access Object implementation class of the Course
 */
@Transactional
@Repository("courseDao")
public class CourseDaoImpl implements CourseDao {

	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(Course course) {
		currentSession().save(course);

	}

	@Override
	public void update(Course course) {
		currentSession().update(course);

	}

	@Override
	public void delete(Course course) {
		currentSession().delete(course);

	}

	@Override
	public Course find(Long courseId) {
		return currentSession().get(Course.class, courseId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getAll() {
		return currentSession().createQuery("from Course").getResultList();
	}

}
