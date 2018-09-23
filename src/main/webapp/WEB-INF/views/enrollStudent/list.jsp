<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:attribute name="header"></jsp:attribute>
    <jsp:attribute name="footer"></jsp:attribute>
    <jsp:body>
		<div style="margin: 10px">
			<h3>Enroll Student To a Course</h3>
		</div>
		<hr/>
		<spring:url value="/enrollStudent/register" var="register" />
		<div class="form-group">
			<a class="btn btn-outline-primary btn-sm" href="${register}"> Create Enroll Student To a Course</a>
			<br/>
		</div>
		
		<c:if test="${!empty enrollStudentList}">
		<div class="table-responsive">
			<table class="table table-striped table-hover">
				<caption>List of Enroll Students to a Course</caption>
				<thead class="thead-light">
					<tr>
						<th>ID</th>
						<th>Course Name</th>
						<th>Student Name</th>
						<th>Final Marks</th>
						<th>Status</th>
						<th>Created Date</th>
						<th>Last Modified Date</th>
						<th>Settings</th>
					</tr>
				</thead>
				<c:forEach items="${enrollStudentList}" var="enroll">
					<tr>
						<td><c:out value="${enroll.enrId}" /></td>
						<td><c:out value="${enroll.course.cName}" /></td>
						<td><c:out value="${enroll.student.fName} ${enroll.student.lName}" /></td>
						<td><c:out value="${enroll.finalMarks}" /></td>
						<td><c:out value="${enroll.status}" /></td>
						<td><c:out value="${enroll.createdDate}" /></td>
						<td><c:out value="${enroll.lastModifiedDate}" /></td>
						<td>
							<a href="<c:url value='/enrollStudent/edit/${enroll.enrId}'/>"    class="btn btn-outline-warning btn-sm" >Edit</a>
							<a href="<c:url value='/enrollStudent/delete/${enroll.enrId}'/>"  class="btn btn-outline-danger btn-sm"  >Delete</a>
							<a href="<c:url value='/enrollStudent/details/${enroll.enrId}'/>" class="btn btn-outline-success btn-sm" >Details</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		</c:if>
	</jsp:body>
</t:genericpage>