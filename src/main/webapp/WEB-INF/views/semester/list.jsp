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
			<h3>Semester</h3>
		</div>
		<hr/>
		<spring:url value="/semester/register" var="register" />
		<div class="form-group">
			<a class="btn btn-outline-primary btn-sm" href="${register}"> Create Semester</a>
			<br/>
		</div>
		
		<c:if test="${!empty semesterList}">
		<div class="table-responsive">
			<table class="table table-striped table-hover">
				<caption>List of semesters</caption>
				<thead class="thead-light">
					<tr>
						<th>ID</th>
						<th>Semester Description</th>
						<th>Status</th>
						<th>Created Date</th>
						<th>Last Modified Date</th>
						<th>Settings</th>
					</tr>
				</thead>
				<c:forEach items="${semesterList}" var="sem">
					<tr>
						<td><c:out value="${sem.semId}" /></td>
						<td><c:out value="${sem.semDescr}" /></td>
						<td><c:out value="${sem.status}" /></td>
						<td><c:out value="${sem.createdDate}" /></td>
						<td><c:out value="${sem.lastModifiedDate}" /></td>
						<td>
							<a href="<c:url value='/semester/edit/${sem.semId}'/>"    class="btn btn-outline-warning btn-sm" >Edit</a>
							<a href="<c:url value='/semester/delete/${sem.semId}'/>"  class="btn btn-outline-danger btn-sm"  >Delete</a>
							<a href="<c:url value='/semester/details/${sem.semId}'/>" class="btn btn-outline-success btn-sm" >Details</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		</c:if>
	</jsp:body>
</t:genericpage>