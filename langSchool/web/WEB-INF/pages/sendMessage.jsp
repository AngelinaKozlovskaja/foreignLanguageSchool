<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Отправить сообщение</title>
</head>
<body>
<form:form method="POST"  modelAttribute="message" class="form-signin">
    <h2 class="form-signin-heading">Оставьте сообщение</h2>
    <spring:bind path="content">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" path="content" class="form-control" placeholder="content"
                        autofocus="true"></form:input>
            <form:errors path="content"></form:errors>
        </div>
    </spring:bind>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Send</button>
</form:form>
</body>
</html>
