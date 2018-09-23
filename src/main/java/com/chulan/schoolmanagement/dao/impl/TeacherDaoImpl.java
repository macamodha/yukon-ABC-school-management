package com.chulan.schoolmanagement.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chulan.schoolmanagement.dao.TeacherDao;
import com.chulan.schoolmanagement.model.Teacher;

/**
 * @author chulan
 * Data Access Object implementation class of the Teacher
 */
@Transactional
@Repository("teacherDao")
public class TeacherDaoImpl implements TeacherDao {

	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(Teacher teacher) {
		currentSession().save(teacher);

	}

	@Override
	public void update(Teacher teacher) {
		currentSession().update(teacher);

	}

	@Override
	public void delete(Teacher teacher) {
		currentSession().delete(teacher);

	}

	@Override
	public Teacher find(Long teachId) {
		return currentSession().get(Teacher.class, teachId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> getAll() {
		return currentSession().createQuery("from Teacher").getResultList();
	}

}
