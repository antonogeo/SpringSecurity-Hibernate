<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <link href="<c:url value="/resources/theme/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/theme/css/starter-template.css" />" rel="stylesheet">
    <title>Dashboard</title>
</head>
<body>

<jsp:include page="top.jsp" />

<div class="container">
    <div class="starter-template">

        <h1>Dashboard</h1>

        <p class="lead">The ultimate dashboard!</p><br />

        <c:out value='${message}' /><br />

        Welcome <c:out value="${user.user.username}" /><br />

        <br />
        <form action="/customSecurityImplementation/logout" name="logout" method="get" >
            <input type="submit" value="Logout">
        </form>



    </div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="<c:url value="/resources/theme/js/bootstrap.min.js" />"></script>
</body>
</html>