package com.chulan.schoolmanagement.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.chulan.schoolmanagement.dao.GradeDao;
import com.chulan.schoolmanagement.model.Grade;
import com.chulan.schoolmanagement.service.GradeService;

/**
 * @author chulan Service implementation class of the Grade
 */

@Service("gradeService")
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class GradeServiceImpl implements GradeService {

	@Autowired
	GradeDao gradeDao;

	@Override
	public String create(Grade grade, BindingResult result, Map<String, Object> map) {

		// Model validation for errors
		if (result.hasErrors()) {
			return "grade/create";
		}

		// set created and last modified date
		grade.setCreatedDate(java.util.Calendar.getInstance().getTime());
		grade.setLastModifiedDate(java.util.Calendar.getInstance().getTime());

		gradeDao.create(grade);
		return "redirect:/grade/list";
	}

	@Override
	public String update(Grade grade, BindingResult result, Map<String, Object> map) {

		gradeDao.update(grade);
		// Model validation for errors
		if (result.hasErrors()) {
			return "grade/edit";
		}

		Grade g = gradeDao.find(grade.getGrdId());
		// set updating fields
		grade.setCreatedDate(g.getCreatedDate());
		grade.setLastModifiedDate(java.util.Calendar.getInstance().getTime());

		gradeDao.update(grade);
		return "redirect:/grade/list";
	}

	@Override
	public String delete(Long gradeId, Map<String, Object> map) {

		gradeDao.delete(find(gradeId));
		return "redirect:/grade/list";
	}

	@Override
	public Grade find(Long gradeId) {
		return gradeDao.find(gradeId);
	}

	@Override
	public String getAll(Map<String, Object> map) {

		// add grade list to a map object collection
		map.put("gradeList", gradeDao.getAll());
		return "grade/list";
	}

	@Override
	public String register(Map<String, Object> map) {

		map.put("grade", new Grade());
		return "grade/create";
	}

	@Override
	public String details(Long gId, Map<String, Object> map) {

		Grade grade = gradeDao.find(gId);

		// assign grade details into a map object
		map.put("gradeType", grade.getGradeType());
		map.put("gName", grade.getgName());
		map.put("upperValue", grade.getUpperValue());
		map.put("lowerValue", grade.getLowerValue());
		map.put("createdDate", grade.getCreatedDate());
		map.put("lastModifiedDate", grade.getLastModifiedDate());

		return "grade/details";
	}

	@Override
	public String edit(Long gId, Map<String, Object> map) {

		Grade grade = gradeDao.find(gId);
		map.put("grade", grade);

		return "grade/edit";
	}

}
