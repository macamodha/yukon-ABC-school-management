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
			<h3>Course Details</h3>
		</div>
	
		<div class="form-group" style="padding: 5px">
			<div class="form-group row">
				<div class="col-md-2">
					<label class="font-weight-bold">Course Name </label>
				</div>
				<div class="col-md-4">
					<input type="text" value="${cName}" disabled class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-2">
					<label class="font-weight-bold">Course Status </label>
				</div>
				<div class="col-md-4">
					<input type="text" value="${status}" disabled class="form-control" />
				</div>
				
			</div>
			<hr>
			<!-- //for sub details - Semester -->
			<div class="form-group" style="padding-left: 50%">
				<div >
					<h6>Semester Details</h6>
					<hr>
				</div>
				<div class="form-group row">
					<div class="col-md-4">
						<label class="font-weight-light">Semester Description </label>
					</div>
					<div class="col-md-8">
						<input type="text" value="${semDescr}" disabled class="form-control" />
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-4">
						<label class="font-weight-light">Semester Status </label>
					</div>
					<div class="col-md-8">
						<input type="text" value="${semStatus}" disabled class="form-control" />
					</div>
				</div>
			</div>
			<hr>
			<!-- //for sub details - Teacher -->
			<div class="form-group">
				<div style="padding-right: 50%">
					<h6>Teacher Details</h6>
					<hr>
				</div>
				<div class="form-group row">
					<div class="col-md-2">
						<label class="font-weight-light">First Name </label>
					</div>
					<div class="col-md-4">
						<input type="text" value="${fName}" disabled class="form-control" />
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-2">
						<label class="font-weight-light">Last Name </label>
					</div>
					<div class="col-md-4">
						<input type="text" value="${lName}" disabled class="form-control" />
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-2">
						<label class="font-weight-light">Email </label>
					</div>
					<div class="col-md-4">
						<input type="text" value="${email}" disabled class="form-control" />
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-2">
						<label class="font-weight-light">Mobile </label>
					</div>
					<div class="col-md-4">
						<input type="text" value="${mobile}" disabled class="form-control" />
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-2">
						<label class="font-weight-light">Gender</label>
					</div>
					<div class="col-md-4">
						<input type="text" value="${gender}" disabled class="form-control" />
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-2">
						<label class="font-weight-light">Teacher Status </label>
					</div>
					<div class="col-md-4">
						<input type="text" value="${teachStatus}" disabled class="form-control" />
					</div>
				</div>
			</div>
			<div style="margin: 10px">
				<a href="<c:url value='/course/list' /> " class="btn btn-success">Return to list</a>
				<a href="<c:url value='/course/delete/${semId}' /> "
					class="btn btn-danger">Delete</a>
			</div>
		</div>
	</jsp:body>
</t:genericpage>