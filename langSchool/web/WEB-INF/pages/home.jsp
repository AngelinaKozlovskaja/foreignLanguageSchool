<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Школа ИЯ</title>

    <style type="text/css">

        #content {
            width: 500px; /* Ширина слоя */
            margin: 0 auto 50px; /* Выравнивание по центру */
        }
        #footer {
            position: fixed; /* Фиксированное положение */
            left: 0; bottom: 0; /* Левый нижний угол */
            color: #fff; /* Цвет текста */
            width: 100%; /* Ширина слоя */
        }
        #footer div {
            padding: 10px; /* Поля вокруг текста */
            background: #f4f4fa; /* Цвет фона */
            margin: 0 auto 50px;
            display: inline-block;
        }
        @import url(http://fonts.googleapis.com/css?family=Lato:400,700italic);
        * { padding: 0; margin: 0; }
        body { background: #d8ead3; font-family: 'Lato', sans-serif;
            text-transform: uppercase;
            letter-spacing: 1px;}
            /*background-color: #cccccc;}*/

        header {
            text-align: justify;
            height: 8em;
            padding: 2em 5%;
            background: #77a977;
            color: #fff;
        }

        header::after {
            content: '';
            display: inline-block;
            width: 100%;
        }

        header > div,
        header > div::before,
        header nav,
        header > div h1 {
            display: inline-block;
            vertical-align: middle;
            text-align: left;
        }

        header > div {
            height: 100%;
        }

        header > div::before {
            content: '';
            height: 100%;
        }

        header > div h1 {
            font-size: 3em;
            font-style: italic;
        }

        header nav a {
            padding: 0 0.6em;
            white-space: nowrap;
        }

        header nav a:last-child {
            padding-right: 0;
        }

        @media screen and (max-width: 720px){

            header {
                height: auto;
            }

            header > div,
            header > h1,
            header nav {
                height: auto;
                width: auto;
                display: block;
                text-align: center;
            }
            h1 {
                text-align: center;
            }
        }
    </style>
</head>
<body background="img_main.png">

<c:url value="/sendMessage" var="sender"/>
<c:url value="/courses" var="view"/>
<c:url value="/mymessages" var="mess"/>
<c:url value="/mycourses" var="my"/>
<c:url value="/addrequest" var="adding"/>

<header>
    <h1>Школа иностранных языков "ИЯ"</h1>
    <nav>
        <a href="${view}">Просмотр всех курсов</a>
        <a href="${my}">Мои курсы</a>
        <a href="${sender}">О нас</a>
        <a href="${adding}">Оставить заявку</a>
        <a href="${mess}">Мои уведомления</a>
    </nav>
</header>

</body>
</html>