<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="resources" />
<div id = "header">
	<h2 id = "text-header">Online training</h2>
	<a href="#">
	<button class = "logout-button">
	<fmt:message key="header.logout" />
	</button>
	</a>
	<div id = "lang">
	<form action = "#" method = "POST">
		<button class = "lang-button" value = "ru">Ru</button>
		<button class = "lang-button" value = "en">En</button>
	</form>
	</div>
</div>

