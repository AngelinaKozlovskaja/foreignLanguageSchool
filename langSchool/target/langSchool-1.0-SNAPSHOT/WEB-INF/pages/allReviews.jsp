<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Отзывы</title>

    <style>
        @import url(http://fonts.googleapis.com/css?family=Fredericka+the+Great|EB+Garamond);
        .older {
            list-style: none;
            margin: 0 auto;
            width: 660px;
            counter-reset: li;
        }
        .older li {
            border-bottom: dashed 1px #006699;
            margin-top: 10px;
            box-shadow: 0 1px 4px rgba(0, 0, 0, 0.3), 0 0 40px rgba(0, 0, 0, 0.1) inset;
            padding: 5px;
        }
        .older a {
            text-decoration: none;
            padding: 10px;
            display: block;
            line-height: 30px;
            color: #3A3A3A;
            font-family: 'EB Garamond', serif;
            font-size: 20px;
        }
        .older a:before {
            display: inline-block;
            content: counter(li);
            counter-increment: li;
            height: 30px;
            width: 30px;
            text-align: center;
            border: solid 1px #dedede;
            margin-right: 20px;
            box-shadow: 0 1px 4px rgba(0, 0, 0, 0.3), 0 0 30px rgba(0, 0, 0, 0.1) inset;
            font-family: 'Fredericka the Great', cursive;
            font-size: 24px;
            -webkit-transition: .4s linear;
            transition: .4s linear;
        }
        .older a:hover:before {
            color:#D72F2C;
            -webkit-transform: scale(1.1);
            transform: scale(1.1);
        }
    </style>
</head>
<body>
<table>
    <tr>
        <td>Email</td>
        <td>Отзыв</td>
    </tr>
    <c:forEach var="r" items="${reviews}">
        <ul class="older">
            <li><td>${r.customer.email}</td>
                <td>${r.commentary}</td></li>
        </ul>
<%--        <tr>--%>
<%--            <td>${r.customer.email}</td>--%>
<%--            <td>${r.commentary}</td>--%>
<%--        </tr>--%>

    </c:forEach>
</table>
</body>
</html>
