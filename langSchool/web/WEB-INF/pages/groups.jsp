<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Зачислить студента</title>
</head>
<body>
<table>
    <tr>
        <td>Номер группы</td>
        <td>Язык</td>
        <td>Добавить</td>
    </tr>
    <c:forEach var="gr" items="${groups}">
    <tr>
        <td>${gr.classNumber}</td>
        <td>${gr.lang}</td>
        <td><a href="<c:url value="/groups/${gr.id}"/>">Сюда</a></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
