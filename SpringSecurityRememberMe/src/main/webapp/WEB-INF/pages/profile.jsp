<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
    <title>${profileUser.username}</title>
</head>
<body>

<jsp:include page="top.jsp" />

<div class="container">
    <div class="starter-template">

     <h3>Change Password</h3>

        <sec:authorize access="isRememberMe()">
            <h2> You are authenticated with Remember Me. You need to login again to change your password. </h2>
        </sec:authorize>

        <sec:authorize access="isFullyAuthenticated()">
            <button>Change password</button>
        </sec:authorize>




    </div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="<c:url value='/resources/theme/js/bootstrap.min.js' />"></script>
</body>
</html>
