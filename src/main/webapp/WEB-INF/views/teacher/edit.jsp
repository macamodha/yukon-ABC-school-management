<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
	<jsp:attribute name="header"></jsp:attribute>
	<jsp:attribute name="footer"></jsp:attribute>
	<jsp:body>
		<div style="margin: 10px">
			<h3>Edit Teacher</h3>
		</div>
		<hr />
		<c:url var="action" value="/teacher/update"></c:url>
		
		<div class="form-group" style="margin: 10px">
		<form:form method="post" action="${action}" modelAttribute="teacher">
			<div class="form-group row">
				<div class="col-md-2">
					<form:hidden path="teachId" class="form-control" />
					<form:label path="fName" class="font-weight-bold">First Name </form:label>
				</div>
				<div class="col-md-4">
					<form:input path="fName" class="form-control" />
				</div>
				<div class="col-md-6">
					<form:errors path="fName" class="text-danger" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-2">
					<form:label path="lName" class="font-weight-bold">Last Name </form:label>
				</div>
				<div class="col-md-4">
					<form:input path="lName" class="form-control" />
				</div>
				<div class="col-md-6">
					<form:errors path="lName" class="text-danger" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-2">
					<form:label path="email" class="font-weight-bold">Email Address</form:label>
				</div>
				<div class="col-md-4 ">
					<form:input path="email" class="form-control" />
				</div>
				<div class="col-md-6">
					<form:errors path="email" class="text-danger" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-2">
					<form:label path="mobile" class="font-weight-bold">Mobile</form:label>
				</div>
				<div class="col-md-4 ">
					<form:input path="mobile" class="form-control" />
				</div>
				<div class="col-md-6">
					<form:errors path="mobile" class="text-danger" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-2">
					<form:label path="gender" class="font-weight-bold">Teacher's Gender</form:label>
				</div>
				<div class="col-md-4 ">
					<form:select path="gender" class="form-control dropdown-toggle"> 
						<form:option value="">Select Gender</form:option>
						<form:option value="M">Male</form:option>
	  					<form:option value="F">Female</form:option>
					</form:select>
				</div>
				<div class="col-md-6">
					<form:errors path="gender" class="text-danger" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-2">
					<form:label path="status" class="font-weight-bold">Teacher Status</form:label>
				</div>
				<div class="col-md-4 ">
					<form:select path="status" class="form-control dropdown-toggle"> 
						<form:option value="">Select a Status</form:option>
						<form:option value="A">Active</form:option>
	  					<form:option value="I">Inactive</form:option>
					</form:select>
				</div>
				<div class="col-md-6">
					<form:errors path="status" class="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<hr />
				<input type="submit" value="Update Teacher" class="btn btn-primary" />
				<a href="<c:url value='/teacher/list' />" class="btn btn-success">Return to Teachers</a>
			</div>
		</form:form>
		</div>
	</jsp:body>
</t:genericpage>