<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>
<html>
<head>
<link
	href="<c:url value="${pageContext.request.contextPath}/../webjars/bootstrap/4.0.0/css/bootstrap.min.css" />"
	rel="stylesheet" type="text/css" />

</head>
<body>
	<div id="pageheader">
		<nav class="navbar navbar-expand-md navbar-dark bg-dark">
			<a class="navbar-brand" href="#"></a>
			<button class="navbar-toggler collapsed" type="button"
				data-toggle="collapse" data-target="#navbarsExampleDefault"
				aria-controls="navbarsExampleDefault" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="navbar-collapse collapse" id="navbarsExampleDefault"
				style="">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item"><a class="nav-link"
						href="<c:url value='/user/home'/>">Home </a></li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#"
						id="dropdown01" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">Reference</a>
						<div class="dropdown-menu" aria-labelledby="dropdown01">
							<a class="dropdown-item" href="<c:url value='/grade/list'/>">Grade</a>
							<a class="dropdown-item" href="<c:url value='/student/list'/>">Student</a>
							<a class="dropdown-item" href="<c:url value='/teacher/list'/>">Teacher</a>
							<a class="dropdown-item" href="<c:url value='/semester/list'/>">Semester</a>
						</div>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#"
						id="dropdown02" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">Front Desk</a>
						<div class="dropdown-menu" aria-labelledby="dropdown02">
							<a class="dropdown-item" href="<c:url value='/course/list'/>">Course</a>
							<a class="dropdown-item" href="<c:url value='/enrollStudent/list'/>">Enroll Student</a>
						</div>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#"
						id="dropdown03" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">Reports</a>
						<div class="dropdown-menu" aria-labelledby="dropdown03">
							<a class="dropdown-item" href="<c:url value='/report/list'/>">Individual
								Results Report</a>
						</div>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#"
						id="dropdown04" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">Admin Reference</a>
						<div class="dropdown-menu" aria-labelledby="dropdown04">
							<a class="dropdown-item" href="<c:url value='/user/list'/>">User</a>
						</div>
					</li>
				</ul>
				<form class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="text"
						placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>
		</nav>
		<jsp:invoke fragment="header" />
	</div>
	<div id="body">
		<jsp:doBody />
	</div>
	<div id="pagefooter">
		<jsp:invoke fragment="footer" />
	</div>

	<script
		src="<c:url value="${pageContext.request.contextPath}/../webjars/jquery/3.2.1/dist/jquery.min.js" />"></script>
	<script
		src="<c:url value="${pageContext.request.contextPath}/../webjars/bootstrap/4.0.0/js/bootstrap.min.js" />"></script>
</body>
</html>