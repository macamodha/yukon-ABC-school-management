package com.chulan.schoolmanagement.dao;

import java.util.List;

import com.chulan.schoolmanagement.model.Semester;

/**
 * @author chulan
 * Data Access Object interface of the Semester
 */
public interface SemesterDao {

	public void create(Semester semester);

	public void update(Semester semester);

	public void delete(Semester semester);

	public Semester find(Long semId);

	public List<Semester> getAll();
}
