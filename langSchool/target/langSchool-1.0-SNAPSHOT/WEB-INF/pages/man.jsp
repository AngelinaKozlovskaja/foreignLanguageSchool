<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Администратор</title>
</head>
<body>
    <c:url value="/requests" var="req"/>
    <c:url value="/messages" var="mess"/>

<a href="${req}">Заявки</a>
<a href="${mess}">Сообщения</a>
</body>
</html>
