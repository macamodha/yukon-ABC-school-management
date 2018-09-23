package com.chulan.schoolmanagement.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.chulan.schoolmanagement.dao.TeacherDao;
import com.chulan.schoolmanagement.model.Teacher;
import com.chulan.schoolmanagement.service.TeacherService;

/**
 * @author chulan Service implementation class of the Teacher
 */

@Service("teacherService")
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherDao teacherDao;

	@Override
	public String create(Teacher teacher, BindingResult result, Map<String, Object> map) {

		// Model validation for errors
		if (result.hasErrors()) {
			return "teacher/create";
		}

		// set created and last modified date
		teacher.setCreatedDate(java.util.Calendar.getInstance().getTime());
		teacher.setLastModifiedDate(java.util.Calendar.getInstance().getTime());

		teacherDao.create(teacher);
		return "redirect:/teacher/list";
	}

	@Override
	public String delete(Long teachId, Map<String, Object> map) {

		teacherDao.delete(find(teachId));
		return "redirect:/teacher/list";
	}

	@Override
	public Teacher find(Long stuId) {
		return teacherDao.find(stuId);
	}

	@Override
	public String getAll(Map<String, Object> map) {

		// add teacher list to a map object collection
		map.put("teacherList", teacherDao.getAll());

		return "teacher/list";
	}

	@Override
	public String register(Map<String, Object> map) {

		map.put("teacher", new Teacher());
		return "teacher/create";
	}

	@Override
	public String details(Long tId, Map<String, Object> map) {

		Teacher teacher = teacherDao.find(tId);

		// assign teacher details into a map object
		map.put("fName", teacher.getfName());
		map.put("lName", teacher.getlName());
		map.put("email", teacher.getEmail());
		map.put("mobile", teacher.getMobile());
		map.put("gender", teacher.getGender());
		map.put("status", teacher.getStatus());
		map.put("createdDate", teacher.getCreatedDate());
		map.put("lastModifiedDate", teacher.getLastModifiedDate());

		return "teacher/details";
	}

	@Override
	public String edit(Long teachId, Map<String, Object> map) {

		Teacher teacher = teacherDao.find(teachId);
		map.put("teacher", teacher);

		return "teacher/edit";
	}

	@Override
	public String update(Teacher teacher, BindingResult result, Map<String, Object> map) {

		// Model validation for errors
		if (result.hasErrors()) {
			return "teacher/edit";
		}

		Teacher t = teacherDao.find(teacher.getTeachId());
		// set updating fields
		teacher.setCreatedDate(t.getCreatedDate());
		teacher.setLastModifiedDate(java.util.Calendar.getInstance().getTime());

		teacherDao.update(teacher);
		return "redirect:/teacher/list";

	}

}
