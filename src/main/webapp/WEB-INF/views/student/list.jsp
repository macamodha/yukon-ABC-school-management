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
			<h3>Student</h3>
		</div>
		<hr/>
		<spring:url value="/student/register" var="register" />
		<div class="form-group">
			<a class="btn btn-outline-primary btn-sm" href="${register}"> Register Student</a>
			<br/>
		</div>
		
		<c:if test="${!empty studentList}">
		<div class="table-responsive">
			<table class="table table-striped table-hover">
				<caption>List of students</caption>
				<thead class="thead-light">
					<tr>
						<th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Mobile</th>
						<th>Created Date</th>
						<th>Last Modified Date</th>
						<th>Settings</th>
					</tr>
				</thead>
				<c:forEach items="${studentList}" var="stu">
					<tr>
						<td><c:out value="${stu.stuId}" /></td>
						<td><c:out value="${stu.fName}" /></td>
						<td><c:out value="${stu.lName}" /></td>
						<td><c:out value="${stu.email}" /></td>
						<td><c:out value="${stu.mobile}" /></td>
						<td><c:out value="${stu.createdDate}" /></td>
						<td><c:out value="${stu.lastModifiedDate}" /></td>
						<td>
							<a href="<c:url value='/student/edit/${stu.stuId}'/>"    class="btn btn-outline-warning btn-sm" >Edit</a>
							<a href="<c:url value='/student/delete/${stu.stuId}'/>"  class="btn btn-outline-danger btn-sm"  >Delete</a>
							<a href="<c:url value='/student/details/${stu.stuId}'/>" class="btn btn-outline-success btn-sm" >Details</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		</c:if>
	</jsp:body>
</t:genericpage>