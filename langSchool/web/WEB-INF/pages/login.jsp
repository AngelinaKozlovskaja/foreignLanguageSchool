<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<!DOCTYPE html>
<head>
    <title>Login V18</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="/resources/images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/resources/vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/resources/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/resources/vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/resources/vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/resources/vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/resources/vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/resources/vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/resources/css/util.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/main.css">
    <!--===============================================================================================-->
</head>
<body style="background-color: #666666;">

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <c:url value="/authorization" var="authPost"/>
            <form:form method="POST" action="${authPost}" modelAttribute="customer" class="login100-form validate-form">

                <%--<form class="login100-form validate-form">--%>
                <%--<span class="login100-form-title p-b-43">--%>
                <%--Авторизация--%>
                <%--</span>--%>

                <spring:bind path="login">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <div class="wrap-input100 validate-input" data-validate="Valid email is required: ex@abc.xyz">
                            <form:input type="text" path="login" class="input100"
                                        autofocus="true"></form:input>
                            <span class="focus-input100"></span>
                            <span class="label-input100">Логин</span>
                        </div>
                    </div>
                </spring:bind>

                <spring:bind path="pass">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <div class="wrap-input100 validate-input" >
                            <form:input type="text" path="pass" class="input100"
                                        autofocus="true"></form:input>
                            <span class="focus-input100"></span>
                            <span class="label-input100">Пароль</span>
                        </div>
                    </div>
                </spring:bind>

                <div>

                    <c:url var="registr" value="/registration"/>

                    <div>
                        <a href="${registr}" class="txt1">
                            Зарегистрироваться
                        </a>
                    </div>
                </div>
                <div class="container-login100-form-btn">
                    <button class="login100-form-btn">
                        Войти
                    </button>
                </div>
            </form:form>

            <div class="login100-more" style="background-image: url('/resources/images/bg-01.jpg');">
            </div>
        </div>
    </div>
</div>


<!--===============================================================================================-->
<script src="/resources/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="/resources/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="/resources/vendor/bootstrap/js/popper.js"></script>
<script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="/resources/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="/resources/vendor/daterangepicker/moment.min.js"></script>
<script src="/resources/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="/resources/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="/resources/js/main.js"></script>

</body>
</html>