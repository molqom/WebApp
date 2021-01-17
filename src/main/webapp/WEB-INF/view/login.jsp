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
    <style>
        body{
            background-color: lightgreen;
        }
    </style>
</head>
<body>
<div class="form">

    <form method="POST" action="/WebApp/controller?command=login">
        <h1>Login page</h1>
        <p>test string</p>
        <c:if test="${not empty errorMessage}">
        <div class="error-message">
            ${errorMessage}
        </div>
        </c:if>
        <input type="text" placeholder="Enter Username" name="login" required>
        <input type="password" placeholder="Enter Password" name="password" required>

        <button class="submit" type="submit">Login</button>
    </form>
    <form method="post" action="/WebApp/controller?command=registrationPage">
        <button class="to-registration" type="submit">
            Registration
        </button>
    </form>
</div>
<div id="footer">
    <jsp:include page="parts/footer.jsp"/>
</div>
</body>
</html>