<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Обработка сообщений</title>
</head>
<body>
<c:url var="proc" value="/process"/>
Одобрить или нет
    <form:form action="${proc}" modelAttribute="request">
        <form:checkbox path="accept"/>
        <input type="submit" value="Подтвердить">
    </form:form>
</body>
</html>
