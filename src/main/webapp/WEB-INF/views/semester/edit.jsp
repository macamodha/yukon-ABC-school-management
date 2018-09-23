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
			<h3>Edit Semester</h3>
		</div>
		<hr />
		<c:url var="action" value="/semester/update"></c:url>
		
		<div class="form-group" style="margin: 10px">
		<form:form method="post" action="${action}" modelAttribute="semester">
			<div class="form-group row">
				<div class="col-md-2">
					<form:hidden path="semId" class="form-control" />
					<form:label path="semDescr" class="font-weight-bold">Semester Description </form:label>
				</div>
				<div class="col-md-4">
					<form:input path="semDescr" class="form-control" />
				</div>
				<div class="col-md-6">
					<form:errors path="semDescr" class="text-danger" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-2">
					<form:label path="status" class="font-weight-bold">Semester Status</form:label>
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
				<input type="submit" value="Update Semester" class="btn btn-primary" />
				<a href="<c:url value='/semester/list' />" class="btn btn-success">Return to Semesters</a>
			</div>
		</form:form>
		</div>
	</jsp:body>
</t:genericpage>