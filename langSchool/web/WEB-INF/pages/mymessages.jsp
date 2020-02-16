<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Мои сообщения</title>
</head>
<body>
<table>
    <tr>
        <td>Номер сообщения</td>
        <td>Сообщение</td>
    </tr>
    <c:forEach var="mes" items="${messes}">
        <tr>
            <td>${mes.id}</td>
            <td>${mes.content}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
