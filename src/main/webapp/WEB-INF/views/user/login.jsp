<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="<c:url value="${pageContext.request.contextPath}/../webjars/bootstrap/4.0.0/css/bootstrap.min.css" />"  rel="stylesheet"     type="text/css" />
<title>Insert title here</title>
</head>
<body>
	<h1 class="display-3" style="padding-left:30%">ABC School</h1>
	<div  style="margin: 10px">
		<h6 style="padding-left:30%">Login Screen</h6>
	</div>
	
	<c:url var="action" value="/user/login" ></c:url>
	<div style="padding-left:30%">
		<div class="form-group form-control col-md-4 border border-primary rounded" style="margin: 10px;">
			<form:form method="post" action="${action}" >
				<div class="form-group " >
					<label class="font-weight-bold"> Email Address</label>
					<input type="text" name="email" id="email" class="form-control"/>
				</div>
				<div class="form-group ">
					<label class="font-weight-bold"> Password</label>
					<input type="password" name="psw" id="psw" class="form-control"/>
				</div>
				<div class="form-group">
					<hr/>
					<input type="submit" value="Sign In"  class="btn btn-primary"/>
					<div class="text-danger"> ${message}</div>
				</div>
			</form:form>
			
		</div>
	</div>
	
	<script src="<c:url value="${pageContext.request.contextPath}/../webjars/jquery/3.2.1/dist/jquery.min.js" />"></script>
	<script src="<c:url value="${pageContext.request.contextPath}/../webjars/bootstrap/4.0.0/js/bootstrap.min.js" />"></script>
</body>
</html>