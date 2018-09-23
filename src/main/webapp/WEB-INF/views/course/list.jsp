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
			<h3>Course</h3>
		</div>
		<hr/>
		<spring:url value="/course/register" var="register" />
		<div class="form-group">
			<a class="btn btn-outline-primary btn-sm" href="${register}"> Create Course</a>
			<br/>
		</div>
		
		<c:if test="${!empty courseList}">
		<div class="table-responsive">
			<table class="table table-striped table-hover">
				<caption>List of courses</caption>
				<thead class="thead-light">
					<tr>
						<th>ID</th>
						<th>Course Name</th>
						<th>Status</th>
						<th>Created Date</th>
						<th>Last Modified Date</th>
						<th>Settings</th>
					</tr>
				</thead>
				<c:forEach items="${courseList}" var="course">
					<tr>
						<td><c:out value="${course.crsId}" /></td>
						<td><c:out value="${course.cName}" /></td>
						<td><c:out value="${course.status}" /></td>
						<td><c:out value="${course.createdDate}" /></td>
						<td><c:out value="${course.lastModifiedDate}" /></td>
						<td>
							<a href="<c:url value='/course/edit/${course.crsId}'/>"    class="btn btn-outline-warning btn-sm" >Edit</a>
							<a href="<c:url value='/course/delete/${course.crsId}'/>"  class="btn btn-outline-danger btn-sm"  >Delete</a>
							<a href="<c:url value='/course/details/${course.crsId}'/>" class="btn btn-outline-success btn-sm" >Details</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		</c:if>
	</jsp:body>
</t:genericpage>