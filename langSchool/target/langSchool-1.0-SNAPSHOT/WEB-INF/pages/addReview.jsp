<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление отзыва</title>
</head>
<body>
<c:url value="/saveReview" var="answ"/>
<form:form action="${answ}" modelAttribute="review">
    <form:input path="commentary"/>
    <input type="submit" value="Отправить">
</form:form>
</body>
</html>
