package com.chulan.schoolmanagement.dao;

import java.util.List;

import com.chulan.schoolmanagement.model.Student;

/**
 * @author chulan 
 * Data Access Object interface of the Student
 */
public interface StudentDao {

	public void create(Student student);

	public void update(Student student);

	public void delete(Student student);

	public Student find(Long stuId);

	public List<Student> getAll();
}
