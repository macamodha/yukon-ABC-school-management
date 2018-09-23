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
			<h3>Something Went Wrong :(</h3>
		</div>
		
		<div class="col-md-6" >
			<P class="text-danger">${errorMsg}</P>
		</div>
		<div>
			<P>Please Contact Administrator For more Details.</P>
		</div>
	</jsp:body>
</t:genericpage>