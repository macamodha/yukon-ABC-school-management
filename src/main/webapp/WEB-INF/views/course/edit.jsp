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
			<h3>Edit Course</h3>
		</div>
		<hr />
		<c:url var="action" value="/course/update"></c:url>
		
		<div class="form-group" style="margin: 10px">
		<form:form method="post" action="${action}" modelAttribute="course">
			<div class="form-group row">
				<div class="col-md-2">
					<form:hidden path="crsId" class="form-control" />
					<form:label path="cName" class="font-weight-bold">Course Name </form:label>
				</div>
				<div class="col-md-4">
					<form:input path="cName" class="form-control" />
				</div>
				<div class="col-md-6">
					<form:errors path="cName" class="text-danger" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-2">
					<form:label path="status" class="font-weight-bold">Course Status</form:label>
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
					<form:label path="semester" class="font-weight-bold">Related Semester</form:label>
				</div>
				<div class="col-md-4 ">
					<form:select path="semester.semId" class="form-control dropdown-toggle" >
						<form:option value="">Select a Semester</form:option> 
						<c:forEach items="${semesterList}" var="sem">
							<form:option value="${sem.semId}">${sem.semDescr}</form:option>
						</c:forEach>
					</form:select>
				</div>
				<div class="col-md-6">
					<P class="text-danger">${errorMsgSem}</P>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-2">
					<form:label path="teacher.teachId" class="font-weight-bold">Responsible Teacher</form:label>
				</div>
				<div class="col-md-4 ">
					<form:select path="teacher.teachId" class="form-control dropdown-toggle" > 
						<form:option value="">Select a Teacher</form:option>
						<c:forEach items="${teacherList}" var="teach">
							<form:option value="${teach.teachId}">${teach.fName}  ${teach.lName}</form:option>
						</c:forEach>
					</form:select>
				</div>
				<div class="col-md-6" >
					<P class="text-danger">${errorMsgTeach}</P>
				</div>
			</div>
			<div class="form-group">
				<hr />
				<input type="submit" value="Update Course" class="btn btn-primary" />
				<a href="<c:url value='/course/list' />" class="btn btn-success">Return to Courses</a>
			</div>
		</form:form>
		</div>
	</jsp:body>
</t:genericpage>