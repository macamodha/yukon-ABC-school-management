package com.chulan.schoolmanagement.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.chulan.schoolmanagement.dao.CourseDao;
import com.chulan.schoolmanagement.dao.EnrollStudentDao;
import com.chulan.schoolmanagement.dao.StudentDao;
import com.chulan.schoolmanagement.model.Course;
import com.chulan.schoolmanagement.model.EnrollStudent;
import com.chulan.schoolmanagement.model.Student;
import com.chulan.schoolmanagement.service.EnrollStudentService;

/**
 * @author chulan Service implementation class of the EnrollStudent
 */

@Service("enrollStudentService")
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class EnrollStudentServiceImpl implements EnrollStudentService {

	@Autowired
	EnrollStudentDao enrollStudentDao;

	// to get the list of semesters and teachers
	@Autowired
	CourseDao courseDao;
	@Autowired
	StudentDao studentDao;
	
	//java mail Sender
	@Autowired
    JavaMailSender mailSender;

	// get the active Course list and active Student list to use inside different
	// methods
	public List<Course> activeCourseList() {
		return courseDao.getAll().stream().filter(x -> x.getStatus().equals("A")).collect(Collectors.toList());
	}

	public List<Student> activeStuList() {
		return studentDao.getAll().stream().filter(x -> x.getStatus().equals("A")).collect(Collectors.toList());
	}

	@Override
	public String create(EnrollStudent enrollStudent, BindingResult result, Map<String, Object> map) {

		//validate inputs
		if(validate(enrollStudent,result,map).equals("errors")) {
			return "enrollStudent/create";
		}
		
		// set related course
		enrollStudent.setCourse(courseDao.find(enrollStudent.getCourse().getCrsId()));
		// set related student
		enrollStudent.setStudent(studentDao.find(enrollStudent.getStudent().getStuId()));

		// set created and last modified date
		enrollStudent.setCreatedDate(java.util.Calendar.getInstance().getTime());
		enrollStudent.setLastModifiedDate(java.util.Calendar.getInstance().getTime());

		enrollStudentDao.create(enrollStudent);
		//send the notification to the teacher
		sendMail(enrollStudent);
		return "redirect:/enrollStudent/list";
	}

	@Override
	public String update(EnrollStudent enrollStudent, BindingResult result, Map<String, Object> map) {

		//validate inputs
		if(validate(enrollStudent,result,map).equals("errors")) {
			return "enrollStudent/edit";
		}
		
		// set related course
		enrollStudent.setCourse(courseDao.find(enrollStudent.getCourse().getCrsId()));
		// set related student
		enrollStudent.setStudent(studentDao.find(enrollStudent.getStudent().getStuId()));
		// set updating fields
		enrollStudent.setCreatedDate(enrollStudentDao.find(enrollStudent.getEnrId()).getCreatedDate());
		enrollStudent.setLastModifiedDate(java.util.Calendar.getInstance().getTime());

		enrollStudentDao.update(enrollStudent);
		return "redirect:/enrollStudent/list";
	}

	@Override
	public EnrollStudent find(Long enrollStudentId) {
		return enrollStudentDao.find(enrollStudentId);
	}

	@Override
	public String getAll(Map<String, Object> map) {

		// add enrollStudent list to a map object collection
		map.put("enrollStudentList", enrollStudentDao.getAll());
		return "enrollStudent/list";
	}

	@Override
	public String delete(Long esId, Map<String, Object> map) {

		enrollStudentDao.delete(find(esId));
		return "redirect:/enrollStudent/list";
	}

	@Override
	public String register(Map<String, Object> map) {

		map.put("enrollStudent", new EnrollStudent());

		// lamda expressions only to get the active status of the model tuples
		map.put("courseService", activeCourseList());
		map.put("studentService", activeStuList());

		return "enrollStudent/create";
	}

	@Override
	public String details(Long esId, Map<String, Object> map) {

		EnrollStudent enrollStudent = enrollStudentDao.find(esId);

		// assign enrollStudent details into a map object
		map.put("enrId", enrollStudent.getEnrId());
		map.put("finalMarks", enrollStudent.getFinalMarks());
		map.put("status", enrollStudent.getStatus());

		map.put("cName", enrollStudent.getCourse().getcName());
		map.put("status", enrollStudent.getCourse().getStatus());

		map.put("semDescr", enrollStudent.getCourse().getSemester().getSemDescr());
		map.put("semStatus", enrollStudent.getCourse().getSemester().getStatus());

		map.put("fNameTeach", enrollStudent.getCourse().getTeacher().getfName());
		map.put("lNameTeach", enrollStudent.getCourse().getTeacher().getlName());
		map.put("emailTeach", enrollStudent.getCourse().getTeacher().getEmail());
		map.put("mobileTeach", enrollStudent.getCourse().getTeacher().getMobile());
		map.put("genderTeach", enrollStudent.getCourse().getTeacher().getGender());
		map.put("teachStatus", enrollStudent.getCourse().getTeacher().getStatus());

		map.put("fNameStu", enrollStudent.getStudent().getfName());
		map.put("lNameStu", enrollStudent.getStudent().getlName());
		map.put("emailStu", enrollStudent.getStudent().getEmail());
		map.put("mobileStu", enrollStudent.getStudent().getMobile());
		map.put("studentType", enrollStudent.getStudent().getStudentType());
		map.put("genderStu", enrollStudent.getStudent().getGender());
		map.put("statusStu", enrollStudent.getStudent().getStatus());

		map.put("createdDate", enrollStudent.getCreatedDate());
		map.put("lastModifiedDate", enrollStudent.getLastModifiedDate());

		return "enrollStudent/details";
	}

	@Override
	public String edit(Long esId, Map<String, Object> map) {

		EnrollStudent enrollStudent = enrollStudentDao.find(esId);
		// lamda expressions only to get the active status of the model tuples
		map.put("courseService", activeCourseList());
		map.put("studentService", activeStuList());

		map.put("enrollStudent", enrollStudent);

		return "enrollStudent/edit";
	}
	
	public String validate(EnrollStudent enrollStudent, BindingResult result, Map<String, Object> map) {
		
		boolean isOk = true; // validation logical variable
		// Model validation for errors
		if (result.hasErrors()) {
			isOk = false;
		}
		// course validate
		if (enrollStudent.getCourse().getCrsId() == null) {
			map.put("errorMsgCrs", "Related Course cannot be blank.");
			isOk = false;
		}
		// student validate
		if (enrollStudent.getStudent().getStuId() == null) {
			map.put("errorMsgStu", "Enrolling Student cannot be blank.");
			isOk = false;
		}
		// check for duplicate records
		if (enrollStudent.getCourse().getCrsId() != null && enrollStudent.getStudent().getStuId() != null) {

			for (EnrollStudent es : enrollStudentDao.getAll()) {
				if (es.getCourse().getCrsId() == enrollStudent.getCourse().getCrsId()
						&& es.getStudent().getStuId() == enrollStudent.getStudent().getStuId()
						&& es.getEnrId() != enrollStudent.getEnrId()) {

					map.put("errorMsg", "Student has already enrolled for the entered course.");
					isOk = false;
				}
			}
		}
		// redirect to the create page
		if (isOk == false) {
			// lamda expressions only to get the active status of the model tuples
			map.put("courseService", activeCourseList());
			map.put("studentService", activeStuList());

			return "errors";
		}
		return "ok";
	}

	@Override
	public void sendMail(EnrollStudent enrollStudent) {
		
		SimpleMailMessage message = new SimpleMailMessage();
			
		String msg = "";
		msg+="Dear "+enrollStudent.getCourse().getTeacher().getfName()+",\n";
		msg+="This is to notify that below listed student is enrolled to the course "+enrollStudent.getCourse().getcName()+" - "+enrollStudent.getCourse().getSemester().getSemDescr()+" from today.\n";
		msg+="Student Name: "+enrollStudent.getStudent().getfName()+" "+enrollStudent.getStudent().getlName()+"\n";
				
			message.setFrom("do-not-reply-to-esample223@gmail.com");
			message.setTo(enrollStudent.getCourse().getTeacher().getEmail());
			message.setSubject("New Student Enroll Notification");
			message.setText(msg);
			mailSender.send(message);
	}
}
