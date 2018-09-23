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
			<h3>Enrolled Student Details</h3>
		</div>
	
		<div class="form-group" style="padding: 5px">
			<!-- //for sub details - Student -->
			<div class="form-group">
				<div style="padding-right: 50%">
					<h6>Student Details</h6>
					<hr>
				</div>
				<div class="form-group row">
					<div class="col-md-2">
						<label class="font-weight-light">First Name </label>
					</div>
					<div class="col-md-4">
						<input type="text" value="${fNameStu}" disabled class="form-control" />
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-2">
						<label class="font-weight-light">Last Name </label>
					</div>
					<div class="col-md-4">
						<input type="text" value="${lNameStu}" disabled class="form-control" />
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-2">
						<label class="font-weight-light">Email </label>
					</div>
					<div class="col-md-4">
						<input type="text" value="${emailStu}" disabled class="form-control" />
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-2">
						<label class="font-weight-light">Mobile </label>
					</div>
					<div class="col-md-4">
						<input type="text" value="${mobileStu}" disabled class="form-control" />
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-2">
						<label class="font-weight-light">Student Type </label>
					</div>
					<div class="col-md-4">
						<input type="text" value="${studentType}" disabled class="form-control" />
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-2">
						<label class="font-weight-light">Gender</label>
					</div>
					<div class="col-md-4">
						<input type="text" value="${genderStu}" disabled class="form-control" />
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-2">
						<label class="font-weight-light">Student Status </label>
					</div>
					<div class="col-md-4">
						<input type="text" value="${statusStu}" disabled class="form-control" />
					</div>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-2">
					<label class="font-weight-light">Final Marks </label>
				</div>
				<div class="col-md-4">
					<input type="text" value="${finalMarks}" disabled class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-2">
					<label class="font-weight-light">Student Enroll Status </label>
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
						<input type="text" value="${fNameTeach}" disabled class="form-control" />
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-2">
						<label class="font-weight-light">Last Name </label>
					</div>
					<div class="col-md-4">
						<input type="text" value="${lNameTeach}" disabled class="form-control" />
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-2">
						<label class="font-weight-light">Email </label>
					</div>
					<div class="col-md-4">
						<input type="text" value="${emailTeach}" disabled class="form-control" />
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-2">
						<label class="font-weight-light">Mobile </label>
					</div>
					<div class="col-md-4">
						<input type="text" value="${mobileTeach}" disabled class="form-control" />
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-2">
						<label class="font-weight-light">Gender</label>
					</div>
					<div class="col-md-4">
						<input type="text" value="${genderTeach}" disabled class="form-control" />
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