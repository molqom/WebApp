<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<c:set var="current" value="${param.lang}" scope="session" />
<c:if test="${not empty current}">
    <fmt:setLocale value="${param.lang}"/>
</c:if>
<fmt:setBundle basename="resources" scope="session" />

<html>
<head>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style/style.css">
</head>
<body>
<div class = "header">
<jsp:include page="parts/header.jsp" />
</div>
<div class = "menu">
<jsp:include page="parts/menu.jsp" />
</div>
<div class = "info"><fmt:message key="menu.main" />

	<button class = "lang-button" type="submit" formaction="#" formmethod="POST" value="ru">Ru</button>

	<form action="#" method="POST">
	    <select name="lang">
	        <option value="ru">Ru</option>
	        <option value="en">En</option>
	    </select>
	    <input type="submit" value="change" />
	</form>
	<h2>v1</h2>
</div>
</body>
</html>