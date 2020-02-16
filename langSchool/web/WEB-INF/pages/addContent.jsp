<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Отправить сообщение</title>
</head>
<body>
<c:url value="/answer" var="answ"/>
    <form:form action="${answ}" modelAttribute="answer">
        <form:input path="content"/>
        <input type="submit" value="Отправить">
    </form:form>
</body>
</html>
