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
			<h3>Edit Grade</h3>
		</div>
		<hr />
		<c:url var="action" value="/grade/update"></c:url>
		
		<div class="form-group" style="margin: 10px">
		<form:form method="post" action="${action}" modelAttribute="grade">
			<div class="form-group row">
				<div class="col-md-2">
					<form:hidden path="grdId" class="form-control" />
					<form:label path="gName" class="font-weight-bold">Grade Name </form:label>
				</div>
				<div class="col-md-4">
					<form:input path="gName" class="form-control" />
				</div>
				<div class="col-md-6">
					<form:errors path="gName" class="text-danger" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-2">
					<form:label path="upperValue" class="font-weight-bold">Upper Mark Value</form:label>
				</div>
				<div class="col-md-4">
					<form:input path="upperValue" class="form-control" />
				</div>
				<div class="col-md-6">
					<form:errors path="upperValue" class="text-danger" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-2">
					<form:label path="lowerValue" class="font-weight-bold">Lower Mark Value</form:label>
				</div>
				<div class="col-md-4">
					<form:input path="lowerValue" class="form-control" />
				</div>
				<div class="col-md-6">
					<form:errors path="lowerValue" class="text-danger" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-2">
					<form:label path="gradeType" class="font-weight-bold">Grade Type</form:label>
				</div>
				<div class="col-md-4 ">
					<form:select path="gradeType" class="form-control dropdown-toggle" > 
						<form:option value="">Select a Grade Type</form:option>
						<form:option value="I">Internal</form:option>
	  					<form:option value="E">External</form:option>
					</form:select>
				</div>
				<div class="col-md-6">
					<form:errors  path="gradeType" class="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<hr />
				<input type="submit" value="Update Grade" class="btn btn-primary" />
				<a href="<c:url value='/grade/list' />" class="btn btn-success">Return to Grades</a>
			</div>
		</form:form>
		</div>
	</jsp:body>
</t:genericpage>