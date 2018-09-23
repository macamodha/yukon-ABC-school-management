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
			<h3>Teacher</h3>
		</div>
		<hr/>
		<spring:url value="/teacher/register" var="register" />
		<div class="form-group">
			<a class="btn btn-outline-primary btn-sm" href="${register}"> Register Teacher</a>
			<br/>
		</div>
		
		<c:if test="${!empty teacherList}">
		<div class="table-responsive">
			<table class="table table-striped table-hover">
				<caption>List of Teachers</caption>
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
				<c:forEach items="${teacherList}" var="teach">
					<tr>
						<td><c:out value="${teach.teachId}" /></td>
						<td><c:out value="${teach.fName}" /></td>
						<td><c:out value="${teach.lName}" /></td>
						<td><c:out value="${teach.email}" /></td>
						<td><c:out value="${teach.mobile}" /></td>
						<td><c:out value="${teach.createdDate}" /></td>
						<td><c:out value="${teach.lastModifiedDate}" /></td>
						<td>
							<a href="<c:url value='/teacher/edit/${teach.teachId}'/>"    class="btn btn-outline-warning btn-sm" >Edit</a>
							<a href="<c:url value='/teacher/delete/${teach.teachId}'/>"  class="btn btn-outline-danger btn-sm"  >Delete</a>
							<a href="<c:url value='/teacher/details/${teach.teachId}'/>" class="btn btn-outline-success btn-sm" >Details</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		</c:if>
	</jsp:body>
</t:genericpage>