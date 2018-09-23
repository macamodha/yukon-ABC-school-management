package com.chulan.schoolmanagement.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.chulan.schoolmanagement.dao.SemesterDao;
import com.chulan.schoolmanagement.model.Semester;
import com.chulan.schoolmanagement.service.SemesterService;

/**
 * @author chulan Service implementation class of the Semester
 */

@Service("semesterService")
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class SemesterServiceImpl implements SemesterService {

	@Autowired
	SemesterDao semesterDao;

	@Override
	public String create(Semester semester, BindingResult result, Map<String, Object> map) {

		// Model validation for errors
		if (result.hasErrors()) {
			return "semester/create";
		}

		// set created and last modified date
		semester.setCreatedDate(java.util.Calendar.getInstance().getTime());
		semester.setLastModifiedDate(java.util.Calendar.getInstance().getTime());

		semesterDao.create(semester);
		return "redirect:/semester/list";
	}

	@Override
	public String update(Semester semester, BindingResult result, Map<String, Object> map) {

		// Model validation for errors
		if (result.hasErrors()) {
			return "semester/edit";
		}

		Semester s = semesterDao.find(semester.getSemId());
		// set updating fields
		semester.setCreatedDate(s.getCreatedDate());
		semester.setLastModifiedDate(java.util.Calendar.getInstance().getTime());

		semesterDao.update(semester);
		return "redirect:/semester/list";
	}

	@Override
	public String delete(Long semId, Map<String, Object> map) {

		semesterDao.delete(find(semId));
		return "redirect:/semester/list";
	}

	@Override
	public Semester find(Long semId) {
		return semesterDao.find(semId);
	}

	@Override
	public String getAll(Map<String, Object> map) {

		// add semester list to a map object collection
		map.put("semesterList", semesterDao.getAll());
		return "semester/list";
	}

	@Override
	public String register(Map<String, Object> map) {

		map.put("semester", new Semester());
		return "semester/create";
	}

	@Override
	public String details(Long sId, Map<String, Object> map) {

		Semester semester = semesterDao.find(sId);

		// assign semester details into a map object
		map.put("semDescr", semester.getSemDescr());
		map.put("status", semester.getStatus());
		map.put("createdDate", semester.getCreatedDate());
		map.put("lastModifiedDate", semester.getLastModifiedDate());

		return "semester/details";
	}

	@Override
	public String edit(Long sId, Map<String, Object> map) {
		Semester semester = semesterDao.find(sId);
		map.put("semester", semester);

		return "semester/edit";
	}

}
