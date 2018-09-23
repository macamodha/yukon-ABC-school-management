<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:attribute name="header"></jsp:attribute>
    <jsp:attribute name="footer"></jsp:attribute>
    <jsp:body>
 		<img style="height:90%;width:70%;padding-left:25%;padding-top:10%" src="<c:url value="/resources/img/homeImage.bmp"/>"/>
	</jsp:body>
</t:genericpage>