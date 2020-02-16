<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Запросы</title>
</head>
<body>
<table>
    <tr>
        <td>Телефон</td>
        <td>Комментарий</td>
        <td>Ответ</td>
    </tr>
    <c:forEach var="req" items="${requests}">
        <tr>
            <td>${req.customer.numberPhone}</td>
            <td>${req.commentary}</td>
            <td><a href="<c:url value="/requests/${req.id}"/>">Ответить</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
