<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <link href="<c:url value="/resources/theme/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/theme/css/signin.css" />" rel="stylesheet">

    <title>Spring & Hibernate Example</title>
</head>
<body onload='document.loginForm.username.focus();'>

<div class="container">

    <form:form action="/customSecurityImplementation/login" commandName="loginForm" cssClass="form-signin">
        <h2 class="form-signin-heading">Welcome!</h2>
        <label for="inputUsername" class="sr-only">Username</label>
        <form:input path="username" id="inputUsername" placeholder="Username" size="30" cssClass="form-control" />
        <form:errors path="username" cssClass="error"/>

        <label for="inputPassword" class="sr-only">Password</label>
        <form:password path="password" id="inputPassword" placeholder="Password" size="30" cssClass="form-control"/>
        <form:errors path="password" cssClass="error"/>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
    </form:form>
    <c:out value='${message}' />

</div>

</body>
</html>