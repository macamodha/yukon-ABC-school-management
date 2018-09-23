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
			<h3>Grade</h3>
		</div>
		<hr/>
		<spring:url value="/grade/register" var="register" />
		<div class="form-group">
			<a class="btn btn-outline-primary btn-sm" href="${register}"> Create Grade</a>
			<br/>
		</div>
		
		<c:if test="${!empty gradeList}">
		<div class="table-responsive">
			<table class="table table-striped table-hover">
				<caption>List of grades</caption>
				<thead class="thead-light">
					<tr>
						<th>ID</th>
						<th>Grade Type</th>
						<th>Grade Name</th>
						<th>Upper Mark Value</th>
						<th>Lower Mark Value</th>
						<th>Created Date</th>
						<th>Last Modified Date</th>
						<th>Settings</th>
					</tr>
				</thead>
				<c:forEach items="${gradeList}" var="grd">
					<tr>
						<td><c:out value="${grd.grdId}" /></td>
						<td><c:out value="${grd.gradeType}" /></td>
						<td><c:out value="${grd.gName}" /></td>
						<td><c:out value="${grd.upperValue}" /></td>
						<td><c:out value="${grd.lowerValue}" /></td>
						<td><c:out value="${grd.createdDate}" /></td>
						<td><c:out value="${grd.lastModifiedDate}" /></td>
						<td>
							<a href="<c:url value='/grade/edit/${grd.grdId}'/>"    class="btn btn-outline-warning btn-sm" >Edit</a>
							<a href="<c:url value='/grade/delete/${grd.grdId}'/>"  class="btn btn-outline-danger btn-sm"  >Delete</a>
							<a href="<c:url value='/grade/details/${grd.grdId}'/>" class="btn btn-outline-success btn-sm" >Details</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		</c:if>
	</jsp:body>
</t:genericpage>