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
			<h3>Semester Details</h3>
		</div>
	
		<div class="form-group" style="padding: 5px">
			<div class="form-group row">
				<div class="col-md-2">
					<label class="font-weight-bold">Semester Description </label>
				</div>
				<div class="col-md-4">
					<input type="text" value="${semDescr}" disabled class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-2">
					<label class="font-weight-bold">Semester Status </label>
				</div>
				<div class="col-md-4">
					<input type="text" value="${status}" disabled class="form-control" />
				</div>
			</div>
			
			<div style="margin: 10px">
				<a href="<c:url value='/semester/list' /> " class="btn btn-success">Return to list</a>
				<a href="<c:url value='/semester/delete/${semId}' /> "
					class="btn btn-danger">Delete</a>
			</div>
		</div>
	</jsp:body>
</t:genericpage>