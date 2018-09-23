package com.chulan.schoolmanagement.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.chulan.schoolmanagement.dao.StudentDao;
import com.chulan.schoolmanagement.model.Student;
import com.chulan.schoolmanagement.service.StudentService;

/**
 * @author chulan Service implementation class of the Student
 */

@Service("studentService")
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;

	@Override
	public String create(Student student, BindingResult result, Map<String, Object> map) {

		// Model validation for errors
		if (result.hasErrors()) {
			return "student/create";
		}

		// set created and last modified date
		student.setCreatedDate(java.util.Calendar.getInstance().getTime());
		student.setLastModifiedDate(java.util.Calendar.getInstance().getTime());

		studentDao.create(student);
		return "redirect:/student/list";
	}

	@Override
	public String update(Student student, BindingResult result, Map<String, Object> map) {

		// Model validation for errors
		if (result.hasErrors()) {
			return "student/edit";
		}

		Student s = studentDao.find(student.getStuId());
		// set updating fields
		student.setCreatedDate(s.getCreatedDate());
		student.setLastModifiedDate(java.util.Calendar.getInstance().getTime());

		studentDao.update(student);
		return "redirect:/student/list";
	}

	@Override
	public Student find(Long stuId) {
		return studentDao.find(stuId);
	}

	@Override
	public String getAll(Map<String, Object> map) {

		// add student list to a map object collection
		map.put("studentList", studentDao.getAll());

		return "student/list";
	}

	@Override
	public String register(Map<String, Object> map) {

		map.put("student", new Student());
		return "student/create";
	}

	@Override
	public String details(Long sId, Map<String, Object> map) {

		Student student = studentDao.find(sId);

		// assign student details into a map object
		map.put("fName", student.getfName());
		map.put("lName", student.getlName());
		map.put("email", student.getEmail());
		map.put("mobile", student.getMobile());
		map.put("studentType", student.getStudentType());
		map.put("gender", student.getGender());
		map.put("status", student.getStatus());
		map.put("createdDate", student.getCreatedDate());
		map.put("lastModifiedDate", student.getLastModifiedDate());

		return "student/details";
	}

	@Override
	public String edit(Long stuId, Map<String, Object> map) {

		Student student = studentDao.find(stuId);
		map.put("student", student);

		return "student/edit";
	}

	@Override
	public String delete(Long sId, Map<String, Object> map) {

		studentDao.delete(find(sId));

		return "redirect:/student/list";
	}

}
