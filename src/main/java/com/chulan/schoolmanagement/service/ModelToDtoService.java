package com.chulan.schoolmanagement.service;

import java.util.List;

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

/**
 * @author chulan 
 * Service interface of the the Model object to DTO and wise-versa 
 */
public interface ModelToDtoService {

	//Course 
	public CourseDto courseToDto(Course course);
	public Course dtoToCourse(CourseDto courseDto);
	public List<CourseDto> courseToDtoList(List<Course> list);
	public List<Course> dtoToCourseList(List<CourseDto> dtoList);
	
	//EnrollStudent 
	public EnrollStudentDto enrollStudentToDto(EnrollStudent enrollStudent);
	public EnrollStudent dtoToEnrollStudent(EnrollStudentDto enrollStudentDto);
	public List<EnrollStudentDto> enrollStudentToDtoList(List<EnrollStudent> list);
	public List<EnrollStudent> dtoToEnrollStudentList(List<EnrollStudentDto> dtoList);
	
	//Grade 
	public GradeDto gradeToDto(Grade grade);
	public Grade dtoToGrade(GradeDto gradeDto);
	public List<GradeDto> gradeToDtoList(List<Grade> list);
	public List<Grade> dtoToGradeList(List<GradeDto> dtoList);
	
	//Semester 
	public SemesterDto semesterToDto(Semester semester);
	public Semester dtoToSemester(SemesterDto semesterDto);
	public List<SemesterDto> semesterToDtoList(List<Semester> list);
	public List<Semester> dtoToSemesterList(List<SemesterDto> dtoList);
	
	//Student 
	public StudentDto studentToDto(Student student);
	public Student dtoToStudent(StudentDto studentDto);
	public List<StudentDto> studentToDtoList(List<Student> list);
	public List<Student> dtoToStudentList(List<StudentDto> dtoList);
	
	//Teacher 
	public TeacherDto teacherToDto(Teacher teacher);
	public Teacher dtoToTeacher(TeacherDto teacherDto);
	public List<TeacherDto> teacherToDtoList(List<Teacher> list);
	public List<Teacher> dtoToTeacherList(List<TeacherDto> dtoList);
	
	//User 
	public UserDto userToDto(User user);
	public User dtoToUser(UserDto userDto);
	public List<UserDto> userToDtoList(List<User> list);
	public List<User> dtoToUserList(List<UserDto> dtoList);
	

}
