package com.chulan.schoolmanagement.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chulan.schoolmanagement.dao.StudentDao;
import com.chulan.schoolmanagement.model.Student;

/**
 * @author chulan
 * Data Access Object implementation class of the Student
 */
@Transactional
@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(Student student) {
		currentSession().save(student);

	}

	@Override
	public void update(Student student) {
		currentSession().update(student);

	}

	@Override
	public void delete(Student student) {
		currentSession().delete(student);

	}

	@Override
	public Student find(Long stuId) {
		return currentSession().get(Student.class, stuId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAll() {
		return currentSession().createQuery("from Student").getResultList();
	}

}
