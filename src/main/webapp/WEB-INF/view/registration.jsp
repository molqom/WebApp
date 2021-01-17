<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<c:set var="current" value="${sessionScope.lang}" scope="session"/>
<c:if test="${not empty current}">
    <fmt:setLocale value="${sessionScope.lang}"/>
</c:if>
<fmt:setBundle basename="resources" scope="session"/>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style/cubestyle.css">
    <title>Online trainings</title>
</head>
<body>
<div class="form">
<form method="POST" action="/WebApp/controller?command=registration">
    <h1>Registration page</h1>
    <c:if test="${not empty errorMessage}">
        <div class="error-message">
                ${errorMessage}
        </div>
    </c:if>
    <input type="text" placeholder="Enter login" name="login"/>
    <input type="text" placeholder="Enter name" name="name"/>
    <input type="text" placeholder="Enter surname" name="surname"/>
    <input type="password" placeholder="Enter password" name="password"/>
    <input type="password" placeholder="Repeat password" name="repeat-password"/>

    <button class="submit" type="submit">Register</button>
</form>
</div>
<div id="footer">
    <jsp:include page="parts/footer.jsp"/>
</div>
</body>
</html>