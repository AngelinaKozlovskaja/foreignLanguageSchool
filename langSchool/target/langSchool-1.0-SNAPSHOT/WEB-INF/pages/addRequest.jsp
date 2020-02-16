<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Оформление заявки</title>
</head>
<body>
<c:url value="/addrequest" var="answ"/>
<form:form action="${answ}" modelAttribute="tempRequest">
    <form:input path="commentary"/>
    <input type="submit" value="Отправить">
</form:form>
</body>
</html>
