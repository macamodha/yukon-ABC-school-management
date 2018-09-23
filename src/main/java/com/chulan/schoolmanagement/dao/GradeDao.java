package com.chulan.schoolmanagement.dao;

import java.util.List;

import com.chulan.schoolmanagement.model.Grade;

/**
 * @author chulan
 * Data Access Object interface of the Grade
 */
public interface GradeDao {

	public void create(Grade grade);

	public void update(Grade grade);

	public void delete(Grade grade);

	public Grade find(Long gradeId);

	public List<Grade> getAll();
}
