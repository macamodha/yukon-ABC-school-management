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
			<h3>Users</h3>
		</div>
		<hr/>
		<spring:url value="/user/register" var="register" />
		<div class="form-group">
			<a class="btn btn-outline-primary btn-sm" href="${register}"> Register User</a>
			<br/>
		</div>
		
		<c:if test="${!empty userList}">
		<div class="table-responsive">
			<table class="table table-striped table-hover">
				<caption>List of users</caption>
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
				<c:forEach items="${userList}" var="usr">
					<tr>
						<td><c:out value="${usr.userId}" /></td>
						<td><c:out value="${usr.fName}" /></td>
						<td><c:out value="${usr.lName}" /></td>
						<td><c:out value="${usr.email}" /></td>
						<td><c:out value="${usr.mobile}" /></td>
						<td><c:out value="${usr.createdDate}" /></td>
						<td><c:out value="${usr.lastModifiedDate}" /></td>
						<td>
							<a href="<c:url value='/user/edit/${usr.userId}'/>"    class="btn btn-outline-warning btn-sm" >Edit</a>
							<a href="<c:url value='/user/delete/${usr.userId}'/>"  class="btn btn-outline-danger btn-sm"  >Delete</a>
							<a href="<c:url value='/user/details/${usr.userId}'/>" class="btn btn-outline-success btn-sm" >Details</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		</c:if>
	</jsp:body>
</t:genericpage>