package com.chulan.schoolmanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chulan.schoolmanagement.dto.CourseDto;
import com.chulan.schoolmanagement.dto.EnrollStudentDto;
import com.chulan.schoolmanagement.dto.GradeDto;
import com.chulan.schoolmanagement.dto.SemesterDto;
import com.chulan.schoolmanagement.dto.StudentDto;
import com.chulan.schoolmanagement.dto.TeacherDto;
import com.chulan.schoolmanagement.dto.UserDto;
import com.chulan.schoolmanagement.model.Course;
import com.chulan.schoolmanagement.model.EnrollStudent;
import com.chulan.schoolmanagement.model.Grade;
import com.chulan.schoolmanagement.model.Semester;
import com.chulan.schoolmanagement.model.Student;
import com.chulan.schoolmanagement.model.Teacher;
import com.chulan.schoolmanagement.model.User;
import com.chulan.schoolmanagement.service.ModelToDtoService;

@Service("modelToDtoService")
public class ModelToDtoServiceImpl implements ModelToDtoService {

	@Override
	public CourseDto courseToDto(Course course) {

		CourseDto courseDto = new CourseDto(
				course.getCreatedDate(), 
				course.getLastModifiedDate(), 
				course.getCrsId(),
				course.getcName(), 
				course.getStatus(),
				semesterToDto(course.getSemester()),
				teacherToDto(course.getTeacher()));
		return courseDto;
	}

	@Override
	public Course dtoToCourse(CourseDto courseDto) {

		Course course = new Course(
				courseDto.getCreatedDate(), 
				courseDto.getLastModifiedDate(), 
				courseDto.getCrsId(),
				courseDto.getcName(), 
				courseDto.getStatus(),
				dtoToSemester(courseDto.getSemester()),
				dtoToTeacher(courseDto.getTeacher()));
		return course;
	}

	@Override
	public EnrollStudentDto enrollStudentToDto(EnrollStudent enrollStudent) {
		
		EnrollStudentDto enrollStudentDto = new EnrollStudentDto(
				enrollStudent.getCreatedDate(), 
				enrollStudent.getLastModifiedDate(), 
				enrollStudent.getEnrId(), 
				enrollStudent.getFinalMarks(), 
				enrollStudent.getStatus(), 
				courseToDto(enrollStudent.getCourse()), 
				studentToDto(enrollStudent.getStudent()));
		return enrollStudentDto;
	}

	@Override
	public EnrollStudent dtoToEnrollStudent(EnrollStudentDto enrollStudentDto) {
		
		EnrollStudent enrollStudent = new EnrollStudent(
				enrollStudentDto.getCreatedDate(), 
				enrollStudentDto.getLastModifiedDate(), 
				enrollStudentDto.getEnrId(), 
				enrollStudentDto.getFinalMarks(), 
				enrollStudentDto.getStatus(), 
				dtoToCourse(enrollStudentDto.getCourse()), 
				dtoToStudent(enrollStudentDto.getStudent()));
		return enrollStudent;
	}

	@Override
	public GradeDto gradeToDto(Grade grade) {

		GradeDto gradeDto = new GradeDto(
				grade.getCreatedDate(), 
				grade.getLastModifiedDate(), 
				grade.getGrdId(),
				grade.getgName(), 
				grade.getUpperValue(), 
				grade.getLowerValue(), 
				grade.getGradeType());
		return gradeDto;
	}

	@Override
	public Grade dtoToGrade(GradeDto gradeDto) {
		
		Grade grade = new Grade(
				gradeDto.getCreatedDate(), 
				gradeDto.getLastModifiedDate(), 
				gradeDto.getGrdId(),
				gradeDto.getgName(), 
				gradeDto.getUpperValue(), 
				gradeDto.getLowerValue(), 
				gradeDto.getGradeType());
		return grade;
	}

	@Override
	public SemesterDto semesterToDto(Semester semester) {
		
		SemesterDto semesterDto = new SemesterDto(
				semester.getCreatedDate(), 
				semester.getLastModifiedDate(), 
				semester.getSemId(), 
				semester.getSemDescr(), 
				semester.getStatus());
		return semesterDto;
	}

	@Override
	public Semester dtoToSemester(SemesterDto semesterDto) {
		
		Semester semester = new Semester(
				semesterDto.getCreatedDate(), 
				semesterDto.getLastModifiedDate(), 
				semesterDto.getSemId(), 
				semesterDto.getSemDescr(), 
				semesterDto.getStatus());
		return semester;
	}

	@Override
	public StudentDto studentToDto(Student student) {
		
		StudentDto studentDto = new StudentDto(
				student.getCreatedDate(), 
				student.getLastModifiedDate(), 
				student.getfName(), 
				student.getlName(), 
				student.getEmail(), 
				student.getMobile(), 
				student.getStuId(), 
				student.getStudentType(),
				student.getGender(), 
				student.getStatus());
		return studentDto;
	}

	@Override
	public Student dtoToStudent(StudentDto studentDto) {
		
		Student student = new Student(
				studentDto.getCreatedDate(), 
				studentDto.getLastModifiedDate(), 
				studentDto.getfName(), 
				studentDto.getlName(), 
				studentDto.getEmail(), 
				studentDto.getMobile(), 
				studentDto.getStuId(), 
				studentDto.getStudentType(),
				studentDto.getGender(), 
				studentDto.getStatus());
		return student;
	}

	@Override
	public TeacherDto teacherToDto(Teacher teacher) {
		
		TeacherDto teacherDto = new TeacherDto(
				teacher.getCreatedDate(), 
				teacher.getLastModifiedDate(), 
				teacher.getfName(), 
				teacher.getlName(), 
				teacher.getEmail(), 
				teacher.getMobile(), 
				teacher.getTeachId(), 
				teacher.getGender(), 
				teacher.getStatus());
				
		return teacherDto;
	}

	@Override
	public Teacher dtoToTeacher(TeacherDto teacherDto) {
		
		Teacher teacher = new Teacher(
				teacherDto.getCreatedDate(), 
				teacherDto.getLastModifiedDate(), 
				teacherDto.getfName(), 
				teacherDto.getlName(), 
				teacherDto.getEmail(), 
				teacherDto.getMobile(), 
				teacherDto.getTeachId(), 
				teacherDto.getGender(), 
				teacherDto.getStatus());
				
		return teacher;
	}

	@Override
	public UserDto userToDto(User user) {
		
		UserDto userDto = new UserDto(
				user.getCreatedDate(), 
				user.getLastModifiedDate(), 
				user.getfName(), 
				user.getlName(), 
				user.getEmail(), 
				user.getMobile(), 
				user.getUserId(), 
				user.getPsw());
		return userDto;
	}

	@Override
	public User dtoToUser(UserDto userDto) {
		
		User user = new User(
				userDto.getCreatedDate(), 
				userDto.getLastModifiedDate(), 
				userDto.getfName(), 
				userDto.getlName(), 
				userDto.getEmail(), 
				userDto.getMobile(), 
				userDto.getUserId(), 
				userDto.getPsw());
		return user;
	}

	@Override
	public List<CourseDto> courseToDtoList(List<Course> cList) {
		
		List<CourseDto> cDtoList = new ArrayList<>();
		for (Course course : cList) {
			cDtoList.add(courseToDto(course));
		} 
		return cDtoList;
	}

	@Override
	public List<Course> dtoToCourseList(List<CourseDto> cDtoList) {
		
		List<Course> cList = new ArrayList<>();
		for (CourseDto courseDto : cDtoList) {
			cList.add(dtoToCourse(courseDto));
		} 
		return cList;
	}

	@Override
	public List<EnrollStudentDto> enrollStudentToDtoList(List<EnrollStudent> list) {
		
		List<EnrollStudentDto> dtoList = new ArrayList<>();
		for (EnrollStudent var : list) {
			dtoList.add(enrollStudentToDto(var));
		} 
		return dtoList;
	}

	@Override
	public List<EnrollStudent> dtoToEnrollStudentList(List<EnrollStudentDto> dtoList) {
		
		List<EnrollStudent> list = new ArrayList<>();
		for (EnrollStudentDto var : dtoList) {
			list.add(dtoToEnrollStudent(var));
		} 
		return list;
	}

	@Override
	public List<GradeDto> gradeToDtoList(List<Grade> list) {
		
		List<GradeDto> dtoList = new ArrayList<>();
		for (Grade var : list) {
			dtoList.add(gradeToDto(var));
		} 
		return dtoList;
	}

	@Override
	public List<Grade> dtoToGradeList(List<GradeDto> dtoList) {
		
		List<Grade> list = new ArrayList<>();
		for (GradeDto var : dtoList) {
			list.add(dtoToGrade(var));
		} 
		return list;
	}

	@Override
	public List<SemesterDto> semesterToDtoList(List<Semester> list) {
		
		List<SemesterDto> dtoList = new ArrayList<>();
		for (Semester var : list) {
			dtoList.add(semesterToDto(var));
		} 
		return dtoList;
	}

	@Override
	public List<Semester> dtoToSemesterList(List<SemesterDto> dtoList) {
		
		List<Semester> list = new ArrayList<>();
		for (SemesterDto var : dtoList) {
			list.add(dtoToSemester(var));
		} 
		return list;
	}

	@Override
	public List<StudentDto> studentToDtoList(List<Student> list) {
		
		List<StudentDto> dtoList = new ArrayList<>();
		for (Student var : list) {
			dtoList.add(studentToDto(var));
		} 
		return dtoList;
	}

	@Override
	public List<Student> dtoToStudentList(List<StudentDto> dtoList) {
		
		List<Student> list = new ArrayList<>();
		for (StudentDto var : dtoList) {
			list.add(dtoToStudent(var));
		} 
		return list;
	}

	@Override
	public List<TeacherDto> teacherToDtoList(List<Teacher> list) {
		
		List<TeacherDto> dtoList = new ArrayList<>();
		for (Teacher var : list) {
			dtoList.add(teacherToDto(var));
		} 
		return dtoList;
	}

	@Override
	public List<Teacher> dtoToTeacherList(List<TeacherDto> dtoList) {
		
		List<Teacher> list = new ArrayList<>();
		for (TeacherDto var : dtoList) {
			list.add(dtoToTeacher(var));
		} 
		return list;
	}

	@Override
	public List<UserDto> userToDtoList(List<User> list) {
		
		List<UserDto> dtoList = new ArrayList<>();
		for (User var : list) {
			dtoList.add(userToDto(var));
		} 
		return dtoList;
	}

	@Override
	public List<User> dtoToUserList(List<UserDto> dtoList) {
		
		List<User> list = new ArrayList<>();
		for (UserDto var : dtoList) {
			list.add(dtoToUser(var));
		} 
		return list;
	}

}
