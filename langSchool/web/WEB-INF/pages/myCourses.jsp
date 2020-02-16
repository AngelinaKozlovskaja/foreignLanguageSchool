<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Мои курсы</title>
</head>
<body>
<table>
    <tr>
        <td>Группа</td>
        <td>Язык</td>
        <td>Описание</td>
        <td>Оставить отзыв</td>
    </tr>
    <c:forEach var="c" items="${mycourses}">
        <tr>
            <td>${c.classNumber}</td>
            <td>${c.lang.languageName}</td>
            <td>${c.lang.description}</td>
            <td><a href="<c:url value="/mycourses/${c.id}"/>">Оставить</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
