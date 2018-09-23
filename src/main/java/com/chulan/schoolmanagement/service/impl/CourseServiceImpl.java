package com.chulan.schoolmanagement.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.chulan.schoolmanagement.dao.SemesterDao;
import com.chulan.schoolmanagement.dao.TeacherDao;
import com.chulan.schoolmanagement.dao.CourseDao;
import com.chulan.schoolmanagement.model.Course;
import com.chulan.schoolmanagement.model.Semester;
import com.chulan.schoolmanagement.model.Teacher;
import com.chulan.schoolmanagement.service.CourseService;
import com.chulan.schoolmanagement.service.ModelToDtoService;

/**
 * @author chulan Service implementation class of the Course
 */

@Service("courseService")
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDao courseDao;

	// to get the list of semesters and teachers
	@Autowired
	SemesterDao semesterDao;
	@Autowired
	TeacherDao teacherDao;
	
	//DTO
	@Autowired
	ModelToDtoService modelToDtoService;
	

	// get the active teacher list and active semester list to use inside different
	// methods
	public List<Semester> activeSemList() {
		
		return semesterDao.getAll().stream().filter(x -> x.getStatus().equals("A")).collect(Collectors.toList());
	}

	public List<Teacher> activeTeachList() {
		
		return teacherDao.getAll().stream().filter(x -> x.getStatus().equals("A")).collect(Collectors.toList());
	}

	@Override
	public String create(Course course, BindingResult result, Map<String, Object> map) {

		//validate inputs
		if(validate(course,result,map).equals("errors")) {
			return "course/create";
		}

		// set related semester
		course.setSemester(semesterDao.find(course.getSemester().getSemId()));
		// set related teacher
		course.setTeacher(teacherDao.find(course.getTeacher().getTeachId()));

		// set created and last modified date
		course.setCreatedDate(java.util.Calendar.getInstance().getTime());
		course.setLastModifiedDate(java.util.Calendar.getInstance().getTime());

		courseDao.create(course);
		return "redirect:/course/list";
	}

	@Override
	public String update(Course course, BindingResult result, Map<String, Object> map) {

		//validate inputs
		if(validate(course,result,map).equals("errors")) {
			return "course/edit";
		}

		// set related semester
		course.setSemester(semesterDao.find(course.getSemester().getSemId()));
		// set related teacher
		course.setTeacher(teacherDao.find(course.getTeacher().getTeachId()));
		// set updating fields
		course.setCreatedDate(courseDao.find(course.getCrsId()).getCreatedDate());
		course.setLastModifiedDate(java.util.Calendar.getInstance().getTime());

		courseDao.update(course);
		return "redirect:/course/list";
	}

	@Override
	public String delete(Long courseId, Map<String, Object> map) {

		courseDao.delete(find(courseId));
		return "redirect:/course/list";
	}

	@Override
	public Course find(Long courseId) {
		return courseDao.find(courseId);
	}

	@Override
	public String getAll(Map<String, Object> map) {

		// add course list to a map object collection
		map.put("courseList", courseDao.getAll());

		return "course/list";
	}

	@Override
	public String register(Map<String, Object> map) {

		map.put("course", new Course());

		// lamda expressions only to get the active status of the model tuples
		map.put("semesterList", activeSemList());
		map.put("teacherList", activeTeachList());
		return "course/create";
	}

	@Override
	public String details(Long cId, Map<String, Object> map) {

		Course course = courseDao.find(cId);

		// assign course details into a map object
		map.put("cName", course.getcName());
		map.put("status", course.getStatus());

		map.put("semDescr", course.getSemester().getSemDescr());
		map.put("semStatus", course.getSemester().getStatus());

		map.put("fName", course.getTeacher().getfName());
		map.put("lName", course.getTeacher().getlName());
		map.put("email", course.getTeacher().getEmail());
		map.put("mobile", course.getTeacher().getMobile());
		map.put("gender", course.getTeacher().getGender());
		map.put("teachStatus", course.getTeacher().getStatus());

		map.put("createdDate", course.getCreatedDate());
		map.put("lastModifiedDate", course.getLastModifiedDate());

		return "course/details";
	}

	@Override
	public String edit(Long cId, Map<String, Object> map) {

		Course course = courseDao.find(cId);
		// lamda expressions only to get the active status of the model tuples
		map.put("semesterList", activeSemList());
		map.put("teacherList", activeTeachList());

		map.put("course", modelToDtoService.courseToDto(course));

		return "course/edit";
	}
	
	public String validate(Course course, BindingResult result, Map<String, Object> map) {
		
		boolean isOk = true; // validation logical variable
		// Model validation for errors
		if (result.hasErrors()) {
			isOk = false;
		}
		// semester validate
		if (course.getSemester().getSemId() == null) {
			map.put("errorMsgSem", "Related Semester cannot be blank.");
			isOk = false;
		}
		// teacher validate
		if (course.getTeacher().getTeachId() == null) {
			map.put("errorMsgTeach", "Responsible Teacher cannot be blank.");
			isOk = false;
		}
		// redirect to the create page
		if (isOk == false) {
			// lamda expressions only to get the active status of the model tuples
			map.put("semesterList", activeSemList());
			map.put("teacherList", activeTeachList());

			return "errors";
		}
		return "ok";
	}

}
