<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Обработка сообщений</title>
</head>
<body>
<table>
    <tr>
        <td>Email</td>
        <td>Содержание сообщения</td>
        <td>Написать ответ</td>
    </tr>
    <c:forEach var="mes" items="${messages}">
        <tr>
            <td>${mes.sender.email}</td>
            <td>${mes.content}</td>
            <td><a href="<c:url value="/messages/${mes.id}"/>">Ответить</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
