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
			<h3>Available Reports For Courses</h3>
		</div>
		<hr/>
		
		<c:if test="${!empty courseList}">
		<div class="table-responsive">
			<table class="table table-striped table-hover">
				<caption>List of Results Report</caption>
				<thead class="thead-light">
					<tr>
						<th>Course ID</th>
						<th>Course Name</th>
						<th>Report Name</th>
						<th>Settings</th>
					</tr>
				</thead>
				<c:forEach items="${courseList}" var="course">
					<tr>
						<td><c:out value="${course.crsId}" /></td>
						<td><c:out value="${course.cName}" /></td>
						<td><c:out value="Individual Student Report for ${course.cName} in ${course.semester.semDescr}" /></td>
						<td>
							<a href="<c:url value='/report/generate/${course.crsId}'/>"    class="btn btn-outline-primary btn-sm" >Generate Report</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		</c:if>
		<div class="col-md-6">
			<P class="text-danger">${errorMsg}</P>
		</div>
	</jsp:body>
</t:genericpage>