<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Курсы</title>
</head>
<body>

<style type="text/css" media="screen">
    .menu {
        list-style: none;
        padding: 0;
        border: 1px solid rgba(0, 0, 0, .2);
    }

    .menu li {
        overflow: hidden;
        padding: 6px 10px;
        font-size: 20px;
    }

    .menu li:first-child {
        font-weight: bold;
        padding: 15px 0 10px 15px;
        margin-bottom: 10px;
        border-bottom: 1px solid rgba(0, 0, 0, .2);
        border-bottom-left-radius: 10px;
        border-bottom-right-radius: 10px;
        color: #679bb7;
        font-size: 24px;
        box-shadow: 0 10px 20px -5px rgba(0, 0, 0, .2);
    }

    .menu li:first-child:before {
        content: "\2749";
        margin-right: 10px;
    }

    .menu span {
        float: left;
        width: 75%;
        color: #7C7D7F;
    }

    .menu em {
        float: right;
        color: #9c836e;
        font-weight: bold;
    }
</style>

<c:forEach items="${courses}" var="course">
    <ul class="menu">
        <li>Курс</li>
        <li><span>Название:${course.languageName}</span>
            <em>Краткое описание: ${course.description}</em>
            <em>Цена: ${course.costCourse}</em>
            <em><a href="<c:url value="/review/${course.id}"/> ">Просмотреть отзывы</a></em>
    </ul>
</c:forEach>

</body>
</html>
