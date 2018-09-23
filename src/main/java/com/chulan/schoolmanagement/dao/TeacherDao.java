package com.chulan.schoolmanagement.dao;

import java.util.List;

import com.chulan.schoolmanagement.model.Teacher;

/**
 * @author chulan 
 * Data Access Object interface of the Teacher
 */
public interface TeacherDao {

	public void create(Teacher teacher);

	public void update(Teacher teacher);

	public void delete(Teacher teacher);

	public Teacher find(Long teachId);

	public List<Teacher> getAll();
}
