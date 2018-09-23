<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
	<jsp:attribute name="header"></jsp:attribute>
	<jsp:attribute name="footer"></jsp:attribute>
	<jsp:body>
		<div style="padding: 10px">
			<h3>Teacher Details</h3>
		</div>
	
		<div class="form-group" style="padding: 5px">
			<div class="form-group row">
				<div class="col-md-2">
					<label class="font-weight-bold">First Name </label>
				</div>
				<div class="col-md-4">
					<input type="text" value="${fName}" disabled class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-2">
					<label class="font-weight-bold">Last Name </label>
				</div>
				<div class="col-md-4">
					<input type="text" value="${lName}" disabled class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-2">
					<label class="font-weight-bold">Email Address </label>
				</div>
				<div class="col-md-4 ">
					<input type="text" value="${email}" disabled class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-2">
					<label class="font-weight-bold">Mobile </label>
				</div>
				<div class="col-md-4 ">
					<input type="text" value="${mobile}" disabled class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-2">
					<label class="font-weight-bold">Gender </label>
				</div>
				<div class="col-md-4 ">
					<input type="text" value="${gender}" disabled class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-2">
					<label class="font-weight-bold">Teacher Status </label>
				</div>
				<div class="col-md-4 ">
					<input type="text" value="${status}" disabled class="form-control" />
				</div>
			</div>
			<div style="margin: 10px">
				<a href="<c:url value='/teacher/list' /> " class="btn btn-success">Return to list</a>
				<a href="<c:url value='/teacher/delete/${teachId}' /> "
					class="btn btn-danger">Delete</a>
			</div>
		</div>
	</jsp:body>
</t:genericpage>