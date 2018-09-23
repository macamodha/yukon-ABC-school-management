<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
	<jsp:attribute name="header"></jsp:attribute>
	<jsp:attribute name="footer"></jsp:attribute>
	<jsp:body>
		<div style="margin: 10px">
			<h3>Student Enroll To a Course Form</h3>
		</div>
		<hr />
		<c:url var="action" value="/enrollStudent/create"></c:url>
		<div class="form-group" style="margin: 10px">
			<form:form method="post" action="${action}" modelAttribute="enrollStudent">
				<div class="form-group row">
					<div class="col-md-2">
						<form:label path="course" class="font-weight-bold">Course To Enroll</form:label>
					</div>
					<div class="col-md-4 ">
						<form:select path="course.crsId" class="form-control dropdown-toggle" >
							<form:option value="">Select a Course</form:option> 
							<c:forEach items="${courseService}" var="crs">
								<form:option value="${crs.crsId}">${crs.cName}</form:option>
							</c:forEach>
						</form:select>
					</div>
					<div class="col-md-6">
						<P class="text-danger">${errorMsgCrs}</P>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-2">
						<form:label path="student" class="font-weight-bold">Enrolling Student</form:label>
					</div>
					<div class="col-md-4 ">
						<form:select path="student.stuId" class="form-control dropdown-toggle" > 
							<form:option value="">Select a Student</form:option>
							<c:forEach items="${studentService}" var="stu">
								<form:option value="${stu.stuId}">${stu.fName}  ${stu.lName}</form:option>
							</c:forEach>
						</form:select>
					</div>
					<div class="col-md-6" >
						<P class="text-danger">${errorMsgStu}</P>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-2">
						<form:label path="status" class="font-weight-bold">Status</form:label>
					</div>
					<div class="col-md-4 ">
						<form:select path="status" class="form-control dropdown-toggle" > 
							<form:option value="">Select a Status</form:option>
							<form:option value="A">Active</form:option>
		  					<form:option value="I">Inactive</form:option>
						</form:select>
					</div>
					<div class="col-md-6">
						<form:errors  path="status" class="text-danger" />
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-2">
						<form:label path="finalMarks" class="font-weight-bold">Final Marks </form:label>
					</div>
					<div class="col-md-4">
						<form:input path="finalMarks" class="form-control" />
					</div>
					<div class="col-md-6">
						<form:errors path="finalMarks" class="text-danger" />
					</div>
				</div>
				<div class="col-md-6" >
					<P class="text-danger">${errorMsg}</P>
				</div>
				<div class="form-group">
					<hr />
					<input type="submit" value="Create Enroll Student" class="btn btn-primary" />
					<a href="<c:url value='/enrollStudent/list' />" class="btn btn-success">Return to Enroll Lists</a>
				</div>
			</form:form>
		</div>
	</jsp:body>
</t:genericpage>